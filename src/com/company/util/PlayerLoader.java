package com.company.util;

import com.company.player.IPlayerMove;
import com.company.player.Player;
import com.github.marceloaguiarr.valkyrie.Valkyrie;
import com.github.marceloaguiarr.valkyrie.enums.SecurityManagers;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Objects;

public class PlayerLoader {

    static {
        enforceSecurityOnUrlClassLoader();
    }

    //todo - add sandbox support to prevent and malicious code

    public static Player makePlayer(String location, String name, Boolean white) {

        Class<?> PlayerClass = null;
        try {
            PlayerClass = PlayerLoader.classToObject(location, name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return getPlayer(name, white, PlayerClass);
    }

    public static Player getPlayer(String name, Boolean white, Class<?> PlayerClass) {
        try {
            IPlayerMove player = (IPlayerMove) Objects.requireNonNull(PlayerClass).getDeclaredConstructor().newInstance();
            return new Player(player ,name ,white);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Class<?> classToObject(String location, String name) throws ClassNotFoundException {
        try {

            URLClassLoader loader = new URLClassLoader(new URL[]{new URL("file://" + location + "/")});
            return loader.loadClass(name);
        } catch (ClassNotFoundException | MalformedURLException | NoClassDefFoundError e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void enforceSecurityOnUrlClassLoader() {
        Valkyrie.addProfile(URLClassLoader.class, new PluginSecurityProfile());
        Valkyrie.setSecurityManager(SecurityManagers.DEFAULT);

        Valkyrie.start();
    }

}
