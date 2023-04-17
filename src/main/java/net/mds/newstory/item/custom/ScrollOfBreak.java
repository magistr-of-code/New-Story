package net.mds.newstory.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ScrollOfBreak extends Item {
    public ScrollOfBreak(Settings settings) {
        super(settings);
    }
    public static boolean isSelect = false;



    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!isSelect) {
            isSelect = true;
            net.mds.newstory.item.custom.ScrollOfFire.isSelect = false;
            net.mds.newstory.item.custom.ScrollOfCarrying.isSelect = false;
        }
        return super.use(world, user, hand);
    }
}
