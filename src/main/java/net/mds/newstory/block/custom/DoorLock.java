package net.mds.newstory.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static java.lang.Thread.sleep;

public class DoorLock extends HorizontalFacingBlock {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public DoorLock(Settings settings) {
        super(settings);
    }

    public static VoxelShape SHAPE_E = Block.createCuboidShape(4, 0, 0, 12, 16, 16);

    public static VoxelShape SHAPE_N = Block.createCuboidShape(0, 0, 4, 16, 16, 12);

    public static VoxelShape SHAPE_W = Block.createCuboidShape(4, 0, 0, 12, 16, 16);

    public static VoxelShape SHAPE_S = Block.createCuboidShape(0, 0, 4, 16, 16, 12);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {

            int BlocksCancel = 0;

            Block block1 = world.getBlockState(pos.add(1,1,0)).getBlock();
            Block block2 = world.getBlockState(pos.add(-1,1,0)).getBlock();
            Block block3 = world.getBlockState(pos.add(0,1,0)).getBlock();

            Block block4 = world.getBlockState(pos.add(-1,0,0)).getBlock();
            Block block5 = world.getBlockState(pos.add(1,0,0)).getBlock();

            Block block6 = world.getBlockState(pos.add(1,-1,0)).getBlock();
            Block block7 = world.getBlockState(pos.add(-1,-1,0)).getBlock();
            Block block8 = world.getBlockState(pos.add(0,-1,0)).getBlock();

            if (block1 == Blocks.SPRUCE_FENCE) {
                world.breakBlock(pos.add(1,1,0),false);
                BlocksCancel++;
            }

            if (block2 == Blocks.SPRUCE_FENCE) {
                world.breakBlock(pos.add(-1,1,0),false);
                BlocksCancel++;
            }

            if (block3 == Blocks.SPRUCE_FENCE) {
                world.breakBlock(pos.add(0,1,0),false);
                BlocksCancel++;
            }

            if (block4 == Blocks.SPRUCE_FENCE) {
                world.breakBlock(pos.add(-1,0,0),false);
                BlocksCancel++;
            }

            if (block5 == Blocks.SPRUCE_FENCE) {
                world.breakBlock(pos.add(1,0,0),false);
                BlocksCancel++;
            }

            if (block6 == Blocks.SPRUCE_FENCE) {
                world.breakBlock(pos.add(1,-1,0),false);
                BlocksCancel++;
            }

            if (block7 == Blocks.SPRUCE_FENCE) {
                world.breakBlock(pos.add(-1,-1,0),false);
                BlocksCancel++;
            }

            if (block8 == Blocks.SPRUCE_FENCE) {
                world.breakBlock(pos.add(0,-1,0),false);
                BlocksCancel++;
            }

            Block block1r = world.getBlockState(pos.add(0,1,1)).getBlock();
            Block block2r = world.getBlockState(pos.add(0,1,-1)).getBlock();
            Block block3r = world.getBlockState(pos.add(0,1,0)).getBlock();

            Block block4r = world.getBlockState(pos.add(0,0,-1)).getBlock();
            Block block5r = world.getBlockState(pos.add(0,0,1)).getBlock();

            Block block6r = world.getBlockState(pos.add(0,-1,1)).getBlock();
            Block block7r = world.getBlockState(pos.add(0,-1,-1)).getBlock();
            Block block8r = world.getBlockState(pos.add(0,-1,0)).getBlock();

            if (block1r == Blocks.SPRUCE_FENCE) {
                world.breakBlock(pos.add(0,1,1),false);
                BlocksCancel++;
            }

            if (block2r == Blocks.SPRUCE_FENCE) {
                world.breakBlock(pos.add(0,1,-1),false);
                BlocksCancel++;
            }

            if (block3r == Blocks.SPRUCE_FENCE) {
                world.breakBlock(pos.add(0,1,0),false);
                BlocksCancel++;
            }

            if (block4r == Blocks.SPRUCE_FENCE) {
                world.breakBlock(pos.add(0,0,-1),false);
                BlocksCancel++;
            }

            if (block5r == Blocks.SPRUCE_FENCE) {
                world.breakBlock(pos.add(0,0,1),false);
                BlocksCancel++;
            }

            if (block6r == Blocks.SPRUCE_FENCE) {
                world.breakBlock(pos.add(0,-1,1),false);
                BlocksCancel++;
            }

            if (block7r == Blocks.SPRUCE_FENCE) {
                world.breakBlock(pos.add(0,-1,-1),false);
                BlocksCancel++;
            }

            if (block8r == Blocks.SPRUCE_FENCE) {
                world.breakBlock(pos.add(0,-1,0),false);
                BlocksCancel++;
            }

            if (BlocksCancel >= 2) {
                world.breakBlock(pos, false);
            }

        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

}
