package com.github.tumods.tuadventurecraft.blocktypes;

import com.github.tumods.tuadventurecraft.Adventurecraft;
import com.github.tumods.tuadventurecraft.entities.blocks.ChairEntity;
import com.github.tumods.tuadventurecraft.lists.PropertyList;
import com.github.tumods.tuadventurecraft.propertyenums.ChairArmType;
import com.github.tumods.tuadventurecraft.propertyenums.ChairShape;
import com.github.tumods.tuadventurecraft.utility.VoxelShapeHelper;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Map;

public class ChairBlock extends HorizontalBlock {
    public static final EnumProperty<ChairArmType> ARMS;
//    public static final EnumProperty<ChairShape> SHAPE;

    public ChairBlock(Properties properties) {
        super(properties);
        setDefaultState(getDefaultState().with(HORIZONTAL_FACING, Direction.NORTH).with(ARMS, ChairArmType.BOTH));
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        VoxelShape frontRightLeg, backRightLeg, frontLeftLeg, backLeftLeg, seat, backrest, armPoleRight, armPoleLeft, armRestRight, armRestLeft;

        //Create(StartX, StartY, StartZ, EndX, EndY, EndZ)
        frontRightLeg = VoxelShapeHelper.createRotatedShape(state.get(BlockStateProperties.HORIZONTAL_FACING),1, 0, 1, 3, 8, 3);
        backRightLeg = VoxelShapeHelper.createRotatedShape(state.get(BlockStateProperties.HORIZONTAL_FACING),1, 0, 13, 3, 8, 15);
        frontLeftLeg = VoxelShapeHelper.createRotatedShape(state.get(BlockStateProperties.HORIZONTAL_FACING),13, 0, 1, 15, 8, 3);
        backLeftLeg = VoxelShapeHelper.createRotatedShape(state.get(BlockStateProperties.HORIZONTAL_FACING),13, 0, 13, 15, 8, 15);
        seat = VoxelShapeHelper.createRotatedShape(state.get(BlockStateProperties.HORIZONTAL_FACING),0, 8, 0, 16, 9, 16);
        backrest = VoxelShapeHelper.createRotatedShape(state.get(BlockStateProperties.HORIZONTAL_FACING),1, 9, 14, 15, 25, 15);
        armPoleRight = VoxelShapeHelper.createRotatedShape(state.get(BlockStateProperties.HORIZONTAL_FACING),1, 9, 1, 2, 13, 2);
        armPoleLeft = VoxelShapeHelper.createRotatedShape(state.get(BlockStateProperties.HORIZONTAL_FACING),14, 9, 1, 15, 13, 2);
        armRestRight = VoxelShapeHelper.createRotatedShape(state.get(BlockStateProperties.HORIZONTAL_FACING),0, 13, 0, 2, 14, 16);
        armRestLeft = VoxelShapeHelper.createRotatedShape(state.get(BlockStateProperties.HORIZONTAL_FACING),14, 13, 0, 16, 14, 16);

        // Combine all collider shapes together
        switch (state.get(ARMS)) {
            case BOTH:
            default:
                return VoxelShapes.or(frontRightLeg, backRightLeg, frontLeftLeg, backLeftLeg, seat, backrest, armPoleRight, armPoleLeft, armRestRight, armRestLeft);

            case LEFT:
                return VoxelShapes.or(frontRightLeg, backRightLeg, frontLeftLeg, backLeftLeg, seat, backrest, armPoleLeft, armRestLeft);

            case RIGHT:
                return VoxelShapes.or(frontRightLeg, backRightLeg, frontLeftLeg, backLeftLeg, seat, backrest, armPoleRight, armRestRight);

            case NONE:
                return VoxelShapes.or(frontRightLeg, backRightLeg, frontLeftLeg, backLeftLeg, seat, backrest);
        }

    }

    @Override
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTrace) {
        return ChairEntity.createSeat(world, pos, 0.4, player);
    }

    public boolean canAttachChair(BlockState state, boolean isStateSolid, Direction direction) {
        Block block = state.getBlock();

        return block instanceof ChairBlock && ChairBlock.isParallel(state, direction);
    }

    public static boolean isParallel(BlockState p_220253_0_, Direction p_220253_1_) {
        return p_220253_0_.get(HORIZONTAL_FACING).getAxis() == p_220253_1_.rotateY().getAxis();
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        BlockState north = worldIn.getBlockState(currentPos.north());
        BlockState south = worldIn.getBlockState(currentPos.south());
        BlockState east = worldIn.getBlockState(currentPos.east());
        BlockState west = worldIn.getBlockState(currentPos.west());

        return stateIn.with(ARMS, getArmsForPlacement(facing, north, south, east, west));
    }

    public boolean isChairAndSameDirection(BlockState state, Direction facing) {
        return state.getBlock() instanceof ChairBlock;
    }

    protected ChairArmType getArmsForPlacement(Direction facing, BlockState northState, BlockState southState, BlockState eastState, BlockState westState) {
        Adventurecraft.logger.info("Get placement state");
        switch (facing) {
            case NORTH:
                // Consider East(right) and West(left) positions
                if (isChairAndSameDirection(eastState, facing) && isChairAndSameDirection(westState, facing)) {
                    Adventurecraft.logger.info("Face North, Right Arm");
                    return ChairArmType.NONE;
                }
                if (isChairAndSameDirection(westState, facing)) {
                    Adventurecraft.logger.info("Face North, Right Arm");
                    return ChairArmType.RIGHT;
                }
                if (isChairAndSameDirection(eastState, facing)) {
                    Adventurecraft.logger.info("Face North, Left Arm");
                    return ChairArmType.LEFT;
                }
                return ChairArmType.BOTH;

            case SOUTH:
                // Consider West(right) and East(left) positions
                if (isChairAndSameDirection(westState, facing) && isChairAndSameDirection(eastState, facing)) {
                    Adventurecraft.logger.info("Face South, No Arm");
                    return ChairArmType.NONE;
                }
                if (isChairAndSameDirection(eastState, facing)) {
                    Adventurecraft.logger.info("Face South, Right Arm");
                    return ChairArmType.RIGHT;
                }
                if (isChairAndSameDirection(westState, facing)) {
                    Adventurecraft.logger.info("Face South, Left Arm");
                    return ChairArmType.LEFT;
                }
                return ChairArmType.BOTH;

            case EAST:
                // Consider South(right) and North(left) positions
                if (isChairAndSameDirection(southState, facing) && isChairAndSameDirection(northState, facing)) {
                    Adventurecraft.logger.info("Face East, No Arm");
                    return ChairArmType.NONE;
                }
                if (isChairAndSameDirection(northState, facing)) {
                    Adventurecraft.logger.info("Face East, Right Arm");
                    return ChairArmType.RIGHT;
                }
                if (isChairAndSameDirection(southState, facing)) {
                    Adventurecraft.logger.info("Face East, Left Arm");
                    return ChairArmType.LEFT;
                }
                return ChairArmType.BOTH;

            case WEST:
                // Consider North(right) and South(left) positions
                if (isChairAndSameDirection(northState, facing) && isChairAndSameDirection(southState, facing)) {
                    Adventurecraft.logger.info("Face west, No Arm");
                    return ChairArmType.NONE;
                }
                if (isChairAndSameDirection(southState, facing)) {
                    Adventurecraft.logger.info("Face west, Right Arm");
                    return ChairArmType.RIGHT;
                }
                if (isChairAndSameDirection(northState, facing)) {
                    Adventurecraft.logger.info("Face west, Left Arm");
                    return ChairArmType.LEFT;
                }
                return ChairArmType.BOTH;
        }
        return ChairArmType.BOTH;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        IBlockReader blockReader = context.getWorld();
        BlockPos blockPos = context.getPos();

        BlockState north = blockReader.getBlockState(blockPos.north());
        BlockState south = blockReader.getBlockState(blockPos.south());
        BlockState east = blockReader.getBlockState(blockPos.east());
        BlockState west = blockReader.getBlockState(blockPos.west());

        return super.getStateForPlacement(context)
                .with(BlockStateProperties.HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite())
                .with(ARMS, getArmsForPlacement(context.getPlacementHorizontalFacing(), north, south, east, west));
//                .with(SHAPE, ChairShape.STRAIGHT);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> container) {
        container.add(BlockStateProperties.HORIZONTAL_FACING, ARMS);
    }

    static {
        ARMS = PropertyList.CHAIR_ARMS;
//        SHAPE = PropertyList.CHAIR_SHAPE;
    }
}
