package es.hulk.survival.managers.rank.impl;

import es.hulk.survival.managers.rank.Rank;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.OfflinePlayer;

import java.util.Objects;

public class LuckPermsAPI implements Rank {

    private final LuckPerms luckPerms = LuckPermsProvider.get();

    @Override
    public String getName(OfflinePlayer offlinePlayer) {
        User user = luckPerms.getUserManager().getUser(offlinePlayer.getUniqueId());
        assert user != null;
        return user.getPrimaryGroup();
    }

    @Override
    public String getPrefix(OfflinePlayer offlinePlayer) {
        User user = luckPerms.getUserManager().getUser(offlinePlayer.getUniqueId());
        assert user != null;
        return user.getCachedData().getMetaData().getPrefix();
    }
    @Override
    public String getSuffix(OfflinePlayer offlinePlayer) {
        User user = luckPerms.getUserManager().getUser(offlinePlayer.getUniqueId());
        assert user != null;
        return user.getCachedData().getMetaData().getSuffix();
    }
    @Override
    public String getDisplayName(OfflinePlayer offlinePlayer) {
        User user = luckPerms.getUserManager().getUser(offlinePlayer.getUniqueId());
        assert user != null;
        return Objects.requireNonNull(luckPerms.getGroupManager().getGroup(user.getPrimaryGroup())).getDisplayName();
    }
}
