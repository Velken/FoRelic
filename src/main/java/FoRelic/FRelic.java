package FoRelic;

import FoRelic.relics.CursedPearl;
import basemod.BaseMod;
import basemod.ModPanel;
import basemod.interfaces.PostInitializeSubscriber;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;

public class FRelic implements PostInitializeSubscriber {
    public static final Logger logger = LogManager.getLogger(BaseMod.class.getName());
    private static final String MODNAME = "Forbidden Reliquary";
    private static final String AUTHOR = "Velken Iakov";
    private static final String DESCRIPTION = "v0.1.0 - 2 New relics.";
    
    public FRelic() {
        BaseMod.subscribeToPostInitialize(this);
    }

    public static void initialize() {
        FRelic fr = new FRelic();
        logger.info("======================= YOU'VE BEEN CURSED! =======================");
    }

    public void receivePostInitialize() {
        // Mod badge
        Texture badgeTexture = new Texture(Gdx.files.internal("img/FRelicBadge.png"));
        ModPanel settingsPanel = new ModPanel();
        settingsPanel.addLabel("This mod does not have any settings (yet)", 400.0f, 700.0f, (me) -> {});
        BaseMod.registerModBadge(badgeTexture, MODNAME, AUTHOR, DESCRIPTION, settingsPanel);
        
        // RelicStrings
        String jsonString = Gdx.files.internal("localization/FRelic-RelicStrings.json").readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomRelicStrings(jsonString);
        
        // Add relics
        RelicLibrary.add(new CursedPearl());
    }
}