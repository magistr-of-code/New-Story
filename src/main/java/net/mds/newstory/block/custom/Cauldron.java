package net.mds.newstory.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class Cauldron extends HorizontalFacingBlock {
    public static final BooleanProperty FULL = BooleanProperty.of("full");
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public Cauldron(Settings settings) {
        super(settings);
    }

    public static VoxelShape shape = Stream.of(
            Block.createCuboidShape(0, 1, 0, 16, 2, 16),
            Block.createCuboidShape(0, 0, 0, 1, 1, 2),
            Block.createCuboidShape(15, 0, 0, 16, 1, 2),
            Block.createCuboidShape(14, 0, 0, 15, 1, 1),
            Block.createCuboidShape(1, 0, 0, 2, 1, 1),
            Block.createCuboidShape(15, 0, 14, 16, 1, 16),
            Block.createCuboidShape(14, 0, 15, 15, 1, 16),
            Block.createCuboidShape(0, 0, 14, 1, 1, 16),
            Block.createCuboidShape(1, 0, 15, 2, 1, 16),
            Block.createCuboidShape(0, 2, 0, 2, 15, 16),
            Block.createCuboidShape(14, 2, 0, 16, 15, 16),
            Block.createCuboidShape(2, 2, 0, 14, 15, 2),
            Block.createCuboidShape(2, 2, 14, 14, 15, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shape;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx);
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return super.mirror(state, mirror);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return super.rotate(state, rotation);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.get(FULL) && player.getInventory().getStack(player.getInventory().selectedSlot).getItem() == Items.WATER_BUCKET) {
            fillCauldron(world, pos, player, hand, player.getStackInHand(hand),state.cycle(FULL), SoundEvents.ITEM_BUCKET_EMPTY);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    static ActionResult fillCauldron(World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack, BlockState state, SoundEvent soundEvent) {
        if (!world.isClient) {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.BUCKET)));
            player.incrementStat(Stats.FILL_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            world.setBlockState(pos, state);
            world.playSound((PlayerEntity) null, pos, soundEvent, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.emitGameEvent((Entity) null, GameEvent.FLUID_PLACE, pos);
        }
        return ActionResult.success(world.isClient);
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, FULL);
    }

}
