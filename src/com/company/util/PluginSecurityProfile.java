package com.company.util;

import com.github.marceloaguiarr.valkyrie.profiles.SecurityProfile;

import java.io.FilePermission;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.util.PropertyPermission;

public class PluginSecurityProfile implements SecurityProfile {

    //todo - implement security policy
    @Override
    public PermissionCollection getPermissions() {
        Permissions permissions = new Permissions();
        permissions.add(new PropertyPermission("*", "none"));
        permissions.add(new FilePermission("<<ALL FILES>>", "none"));

        return permissions;
    }

}
