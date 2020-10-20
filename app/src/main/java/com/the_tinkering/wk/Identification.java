package com.the_tinkering.wk;

/**
 * A class with static fields that provide identification of the app.
 * Specifically, the name of the app and the name of the author/maintainer.
 *
 * <p>
 *     Note: the open source license applies to the code in the repository, and
 *     it does not extend to the name I gave to the app or my name/email address.
 *     Those are my trademarks.
 *     You are not allowed to use those, they belong to me exclusively. If you
 *     want to fork, share or publish an app based on this code, you MUST NOT use
 *     any name that includes my trademark or name.
 * </p>
 *
 * <p>
 *     Just pick a new name that does not include my name or trademark anywhere
 *     in it. It's fine to acknowledge in documentation that the app derives from
 *     my work, and/or to reference my app. But DO NOT actually use my name or trademark
 *     for any part of your app.
 * </p>
 */
public final class Identification {
    /**
     * The name of the app.
     */
    public static final String APP_NAME = "Nipponese";

    /**
     * The name of the app as used in a User-Agent HTTP header.
     */
    public static final String APP_NAME_UA = "Nipponese";

    /**
     * The name of the app as used in URI schemes.
     */
    public static final String APP_URI_SCHEME = "nipponese";

    /**
     * The name of the author.
     */
    public static final String AUTHOR_NAME = "My Name";

    /**
     * The email address of the author.
     */
    public static final String AUTHOR_EMAIL = "my-name@example.com";

    /**
     * The WaniKani username of the author.
     */
    public static final String AUTHOR_USERNAME = "myusername";

    /**
     * Support URL for the app.
     */
    public static final String SUPPORT_URL = "https://www.example.com/";

    /**
     * Store URL for the app.
     */
    public static final String STORE_URL = "https://www.example.com/";

    private Identification() {
        //
    }
}
