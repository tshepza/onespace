package com.onespace.enums;


/**
 * Available
 */
public enum Material {
    GOLD("Gold"),
    IRON("Iron"),
    SILVER("Silver");

    private String name;

    Material(String metal) {
        this.name = metal;
    }

    public String getName() {
        return name;
    }

    /**
     *  Given the metal name return the respective Material enum
     * @param name
     * @return return the
     */
    public static Material getFromName(String name) {
        if (name == null) {
            return null;
        }
        for (Material material : Material.values()) {
            if (material.getName().equals(name)) {
                return material;
            }
        }
        return null;
    }

}
