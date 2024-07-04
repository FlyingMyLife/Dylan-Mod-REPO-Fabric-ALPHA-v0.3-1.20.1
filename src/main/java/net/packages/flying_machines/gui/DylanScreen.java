package net.packages.flying_machines.gui;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.packages.flying_machines.entity.custom.DylanEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.packages.flying_machines.flying_machines;
import net.packages.flying_machines.item.Items;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class DylanScreen extends HandledScreen<DylanScreenHandler> {
    private static final List<Item> POSITIVE_ITEMS = Arrays.asList(
            Registries.ITEM.get(new Identifier("flying_machines", "beef_tartare")),
            Registries.ITEM.get(new Identifier("minecraft", "cooked_mutton")),
            Registries.ITEM.get(new Identifier("minecraft", "cooked_beef")),
            Registries.ITEM.get(new Identifier("minecraft", "cooked_porkchop")),
            Registries.ITEM.get(new Identifier("minecraft", "diamond")),
            Registries.ITEM.get(new Identifier("minecraft", "netherite_ingot")),
            Registries.ITEM.get(new Identifier("minecraft", "cookie")),
            Registries.ITEM.get(new Identifier("minecraft", "cooked_chicken")),
            Registries.ITEM.get(new Identifier("minecraft", "cooked_cod")),
            Registries.ITEM.get(new Identifier("minecraft", "cooked_salmon")),
            Registries.ITEM.get(new Identifier("minecraft", "cake"))
            );
    private static final List<Item> SCHEME_CUSTOM = Arrays.asList(
            Registries.ITEM.get(new Identifier("flying_machines", "dylan_mk1_scheme"))
    );
    private static final List<Item> NEGATIVE_ITEMS = Arrays.asList(
            Registries.ITEM.get(new Identifier("minecraft", "carrot")),
            Registries.ITEM.get(new Identifier("minecraft", "baked_potato")),
            Registries.ITEM.get(new Identifier("minecraft", "potato")),
            Registries.ITEM.get(new Identifier("minecraft", "beetroot")),
            Registries.ITEM.get(new Identifier("minecraft", "poisonous_potato")),
            Registries.ITEM.get(new Identifier("minecraft", "bread")),
            Registries.ITEM.get(new Identifier("minecraft", "pufferfish")),
            Registries.ITEM.get(new Identifier("minecraft", "rotten_flesh"))
    );
    private DylanEntity dylanEntity;
    private final DylanScreenHandler handler;
    public DylanScreen(DylanScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.handler = handler;
    }
    public Text dylanNameTag = Text.literal("[Дилан] ").styled(style -> style.withColor(0x2686FF));
    private static final long COOLDOWN_TICKS = 20;
    private static long lastPressedTime = 0;
    private ButtonWidget button1;
    private ButtonWidget button2;
    private static final Identifier BUTTON_TEXTURE_1 = new Identifier("flying_machines", "textures/gui/button_1.png");
    private static final Identifier BUTTON_TEXTURE_2 = new Identifier("flying_machines", "textures/gui/button_2.png");
    @Override
    protected void init() {
        super.init();
        this.button1 = this.addDrawableChild(
                new TexturedButtonWidget(
                        220,
                        100,
                        120,
                        20,
                        0,
                        0,
                        20,
                        BUTTON_TEXTURE_1,
                        120,
                        20,
                        button -> handle_make_a_giftPress(),
                        Text.translatable("button.make_a_gift")
                ));
        this.button2 = this.addDrawableChild(
                new TexturedButtonWidget(
                        220,
                        130,
                        120,
                        20,
                        0,
                        0,
                        20,
                        BUTTON_TEXTURE_2,
                        120,
                        20,
                        button -> handle_repairPress(),
                        Text.translatable("button.repair")
                )
        );
        updateButtonState();
    }



    private void updateButtonState() {
        PlayerEntity player = this.client.player;
        if (player == null) return;

        ItemStack heldItemStack = player.getStackInHand(Hand.MAIN_HAND);
        boolean hasItem = !heldItemStack.isEmpty();
        boolean isCooldownOver = this.client.world.getTime() - lastPressedTime > COOLDOWN_TICKS;

        this.button1.active = hasItem && isCooldownOver;
        this.button2.active = !hasItem && !isCopy(1);
    }
    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
    }
    private void handle_make_a_giftPress() {
        PlayerEntity player = this.client.player;
        if (player != null) {
            ItemStack heldItemStack = player.getStackInHand(Hand.MAIN_HAND);
            if (!heldItemStack.isEmpty()) {
                if (POSITIVE_ITEMS.contains(heldItemStack.getItem())) {
                    Text normalText = Text.literal("Это лучше чем донат в моей любимой игре").styled(style -> style.withColor(0xFFFFFF));
                    player.sendMessage(((MutableText) dylanNameTag).append(normalText), false);
                    lastPressedTime = this.client.world.getTime();
                    this.close();
                    player.getInventory().removeStack(player.getInventory().selectedSlot, 1);
                }
                else if (SCHEME_CUSTOM.contains(heldItemStack.getItem())) {
                    Text normalText = Text.literal("Ты нафига мне мою схему подсунул?").styled(style -> style.withColor(0xFFFFFF));
                    player.sendMessage(((MutableText) dylanNameTag).append(normalText), false);
                    lastPressedTime = this.client.world.getTime();
                    this.close();
                    player.getInventory().removeStack(player.getInventory().selectedSlot, 1);
                }
                else if (NEGATIVE_ITEMS.contains(heldItemStack.getItem())) {
                    Text normalText = Text.literal("Фу, убери от меня это").styled(style -> style.withColor(0xFFFFFF));
                    player.sendMessage(((MutableText) dylanNameTag).append(normalText), false);
                    lastPressedTime = this.client.world.getTime();
                    this.close();
                    player.getInventory().removeStack(player.getInventory().selectedSlot, 1);

                }
                else {
                    Text negativeText = Text.literal("Ну окей, спасибо наверное").styled(style -> style.withColor(0xFFFFFF));
                    player.sendMessage(((MutableText) dylanNameTag).append(negativeText), false);
                    player.getInventory().removeStack(player.getInventory().selectedSlot, 1);

                }
            }
        }
    }
    private void handle_repairPress() {

    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        this.updateButtonState();
    }
    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
    }
}