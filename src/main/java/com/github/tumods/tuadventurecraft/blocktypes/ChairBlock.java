package com.github.tumods.tuadventurecraft.blocktypes;

import com.github.tumods.tuadventurecraft.entities.blocks.ChairEntity;
import com.github.tumods.tuadventurecraft.utility.VoxelShapeHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.FaceDirection;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ChairBlock extends Block {
    public ChairBlock(Properties properties) {
        super(properties);
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
        return VoxelShapes.or(frontRightLeg, backRightLeg, frontLeftLeg, backLeftLeg, seat, backrest, armPoleRight, armPoleLeft, armRestRight, armRestLeft);
    }

    @Override
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTrace) {
        return ChairEntity.createSeat(world, pos, 0.4, player);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState blockstate = super.getStateForPlacement(context);

        if (blockstate != null) {
            blockstate = blockstate.with(BlockStateProperties.HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
        }
        return blockstate;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> container) {
        container.add(BlockStateProperties.HORIZONTAL_FACING);
    }
}
