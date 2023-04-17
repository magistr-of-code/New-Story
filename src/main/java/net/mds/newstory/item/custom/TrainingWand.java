package net.mds.newstory.item.custom;

import net.mds.newstory.story.MainStory;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import static net.minecraft.block.Blocks.*;

public class TrainingWand extends Item {
    public TrainingWand(Settings settings) {
        super(settings);
    }
    BlockState state;

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
            BlockPos pos = context.getBlockPos();
            Block block = context.getWorld().getBlockState(pos).getBlock();
            if (net.mds.newstory.item.custom.ScrollOfBreak.isSelect) {
                if(block == YELLOW_WOOL || block == GRAY_WOOL || block == LIGHT_GRAY_WOOL) {
                    MainStory.wand.setActive(true);
                    context.getWorld().breakBlock(pos,true);
                }
            }if (net.mds.newstory.item.custom.ScrollOfFire.isSelect) {
                if(context.getWorld().getBlockState(pos.up(1)).getBlock() == AIR) {
                    MainStory.wand.setActive(true);
                    context.getWorld().setBlockState(pos.up(1), FIRE.getDefaultState());
                }
            }
        if(net.mds.newstory.item.custom.ScrollOfCarrying.isSelect){
            if(!context.getWorld().isClient()){
                if(net.mds.newstory.item.custom.ScrollOfCarrying.HaveBlock) {
                    if(context.getWorld().getBlockState(pos.up(1)).getBlock() == AIR) {
                        MainStory.wand.setActive(true);
                        context.getWorld().setBlockState(pos.up(1), state);
                        net.mds.newstory.item.custom.ScrollOfCarrying.HaveBlock = false;
                    }
                }
                else {
                    if (block != BARRIER && block != BEDROCK) {
                        MainStory.wand.setActive(true);
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
