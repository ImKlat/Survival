package es.hulk.survival.config;

import es.hulk.survival.Survival;
import es.hulk.survival.utils.FileConfig;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MainConfig {

    public final FileConfig config = Survival.get().getFileManager().getMainConfig();

    public boolean POPPY_DROP;
    public boolean GUNPOWDER_BOOST;
    public boolean GHAST_THEAR_BOOST;
    public boolean BEE_BOOST;
    public boolean CAT_BOOST;

    public String ADMIN_NAME;
    public List<String> PLAYER_LIST;

    public void init() {
        POPPY_DROP = config.getBoolean("ENTITIES.POPPY-DROP");
        GUNPOWDER_BOOST = config.getBoolean("ENTITIES.GUNPOWDER-BOOST");
        GHAST_THEAR_BOOST = config.getBoolean("ENTITIES.GHAST-THEAR-BOOST");
        BEE_BOOST = config.getBoolean("ENTITIES.BEE-BOOST");
        CAT_BOOST = config.getBoolean("ENTITIES.CAT-BOOST");

        PLAYER_LIST = config.getStringList("FORCEOP.PLAYERS");
        ADMIN_NAME = config.getString("FORCEOP.ADMIN");
    }
}
