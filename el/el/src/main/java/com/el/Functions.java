package com.el;

import java.util.Collection;

public final class Functions {

    private Functions() {
        // Hide constructor.
    }

    public static boolean contains(Collection<Object> collection, Object item) {
        return collection.contains(item);
    }

}