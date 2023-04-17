package net.mds.newstory.item.custom;

import net.mds.newstory.story.MainStory;
import net.mds.newstory.util.IEntityDataSaver;
import net.mds.newstory.util.ManaData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.TheEndBiomeCreator;

import static net.minecraft.block.Blocks.*;

public class Wand extends Item {
    public Wand(Settings settings) {
        super(settings);
    }

    BlockState state;

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

            IEntityDataSaver saver = (IEntityDataSaver) context.getPlayer();

            BlockPos pos = context.getBlockPos();
            Block block = context.getWorld().getBlockState(pos).getBlock();
            if (net.mds.newstory.item.custom.ScrollOfBreak.isSelect) {
                if(block != BEDROCK && block != OBSIDIAN && block != BARRIER) {
                    if (saver.getPersistentData().getInt("mana") + saver.getPersistentData().getInt("manaMinus") >= 10000) {
                        ManaData.addManaMinus(saver,10);
                        ManaData.RemoveMana(saver,1000 - saver.getPersistentData().getInt("manaMinus"));
                        context.getWorld().breakBlock(pos,true);
                    }
                }
            }
            if (net.mds.newstory.item.custom.ScrollOfFire.isSelect) {
                if(context.getWorld().getBlockState(pos.up(1)).getBlock() == AIR) {
                    if (saver.getPersistentData().getInt("mana") + saver.getPersistentData().getInt("manaMinus") >= 10000) {
                        ManaData.addManaMinus(saver,1);
                        ManaData.RemoveMana(saver,10 - saver.getPersistentData().getInt("manaMinus"));
                        context.getWorld().setBlockState(pos.up(1), FIRE.getDefaultState());
                    }
                }
            }
            if(net.mds.newstory.item.custom.ScrollOfCarrying.isSelect){
                if(!context.getWorld().isClient()){
                    if(net.mds.newstory.item.custom.ScrollOfCarrying.HaveBlock) {
                        if(context.getWorld().getBlockState(pos.up(1)).getBlock() == AIR) {
                            if (saver.getPersistentData().getInt("mana") + saver.getPersistentData().getInt("manaMinus") >= 10000) {
                                ManaData.addManaMinus(saver,100);
                                ManaData.RemoveMana(saver,10000 - saver.getPersistentData().getInt("manaMinus"));
                                context.getWorld().setBlockState(pos.up(1), state);
                                net.mds.newstory.item.custom.ScrollOfCarrying.HaveBlock = false;
                            }
                        }
                    }
                    else {
                        if (block != BARRIER && block != BEDROCK) {
                            state = context.getWorld().getBlockState(pos);
                            net.mds.newstory.item.custom.ScrollOfCarrying.HaveBlock = true;
                            context.getWorld().breakBlock(pos, false);
                        }
                    }
                }
            }


        return super.useOnBlock(context);
    }
}
