package net.ace.moredetectors.item.customitems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class Copper_DetectorItem extends Item {
    public Copper_DetectorItem(Settings settings) {
        super(settings);
    }
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

                if(isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.down(i), player, state.getBlock());
                    foundBlock = true;

                    break;
                }
            }

            if(!foundBlock) {
                player.sendMessage(Text.literal("什么都没找到!"));
            }
        }

        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal( "在 " +
                "[" + "x: "+blockPos.getX() + ", "+"y: "+ blockPos.getY() + ", "+"z: " + blockPos.getZ() + "]"+" 找到: " + "(" + block.asItem().getName().getString() + ")"), false);
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isOf(Blocks.COPPER_ORE) || state.isOf(Blocks.DEEPSLATE_COPPER_ORE) || state.isOf(Blocks.COPPER_BLOCK) || state.isOf(Blocks.TRIAL_SPAWNER);
    }
}
