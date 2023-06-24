package me.nixuge.freezer;

import lombok.Getter;
import lombok.Setter;
import me.nixuge.freezer.keybinds.Keybinds;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = McMod.MOD_ID,
        name = McMod.NAME,
        version = McMod.VERSION,
        clientSideOnly = true
)

@Setter
public class McMod {
    public static final String MOD_ID = "freezer";
    public static final String NAME = "Freezer";
    public static final String VERSION = "1.0.0";

    @Getter
    @Mod.Instance(value = McMod.MOD_ID)
    private static McMod instance;

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event) {
        Keybinds.register();
    }
}
