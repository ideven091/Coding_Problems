package com.cleo.dataStructures;
/*
 * Copyright (c) 2011, 2021, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */




import java.lang.reflect.ReflectPermission;
import java.net.NetPermission;
import java.net.SocketPermission;
import java.security.*;

/*
final class SecurityConstants {
    // Cannot create one of these
    private SecurityConstants () {
    }

    // Commonly used string constants for permission actions used by
    // SecurityManager. Declare here for shortcut when checking permissions
    // in FilePermission, SocketPermission, and PropertyPermission.

    public static final String FILE_DELETE_ACTION = "delete";
    public static final String FILE_EXECUTE_ACTION = "execute";
    public static final String FILE_READ_ACTION = "read";
    public static final String FILE_WRITE_ACTION = "write";
    public static final String FILE_READLINK_ACTION = "readlink";

    public static final String SOCKET_RESOLVE_ACTION = "resolve";
    public static final String SOCKET_CONNECT_ACTION = "connect";
    public static final String SOCKET_LISTEN_ACTION = "listen";
    public static final String SOCKET_ACCEPT_ACTION = "accept";
    public static final String SOCKET_CONNECT_ACCEPT_ACTION = "connect,accept";

    public static final String PROPERTY_RW_ACTION = "read,write";
    public static final String PROPERTY_READ_ACTION = "read";
    public static final String PROPERTY_WRITE_ACTION = "write";

    // Permission constants used in the various checkPermission() calls in JDK.

    // java.lang.Class, java.lang.SecurityManager, java.lang.System,
    // java.net.URLConnection, java.security.AllPermission, java.security.Policy,
    // sun.security.provider.PolicyFile
    public static final AllPermission ALL_PERMISSION = new AllPermission();

    // java.net.URL
    public static final NetPermission SPECIFY_HANDLER_PERMISSION =
            new NetPermission("specifyStreamHandler");

    // java.net.ProxySelector
    public static final NetPermission SET_PROXYSELECTOR_PERMISSION =
            new NetPermission("setProxySelector");

    // java.net.ProxySelector
    public static final NetPermission GET_PROXYSELECTOR_PERMISSION =
            new NetPermission("getProxySelector");

    // java.net.CookieHandler
    public static final NetPermission SET_COOKIEHANDLER_PERMISSION =
            new NetPermission("setCookieHandler");

    // java.net.CookieHandler
    public static final NetPermission GET_COOKIEHANDLER_PERMISSION =
            new NetPermission("getCookieHandler");

    // java.net.ResponseCache
    public static final NetPermission SET_RESPONSECACHE_PERMISSION =
            new NetPermission("setResponseCache");

    // java.net.ResponseCache
    public static final NetPermission GET_RESPONSECACHE_PERMISSION =
            new NetPermission("getResponseCache");

    // java.net.ServerSocket, java.net.Socket
    public static final NetPermission SET_SOCKETIMPL_PERMISSION =
            new NetPermission("setSocketImpl");

    // java.lang.SecurityManager, sun.applet.AppletPanel
    public static final RuntimePermission CREATE_CLASSLOADER_PERMISSION =
            new RuntimePermission("createClassLoader");

    // java.lang.SecurityManager
    public static final RuntimePermission CHECK_MEMBER_ACCESS_PERMISSION =
            new RuntimePermission("accessDeclaredMembers");

    // java.lang.SecurityManager, sun.applet.AppletSecurity
    public static final RuntimePermission MODIFY_THREAD_PERMISSION =
            new RuntimePermission("modifyThread");

    // java.lang.SecurityManager, sun.applet.AppletSecurity
    public static final RuntimePermission MODIFY_THREADGROUP_PERMISSION =
            new RuntimePermission("modifyThreadGroup");

    // java.lang.Class
    public static final RuntimePermission GET_PD_PERMISSION =
            new RuntimePermission("getProtectionDomain");

    // java.lang.Class, java.lang.ClassLoader, java.lang.Thread
    public static final RuntimePermission GET_CLASSLOADER_PERMISSION =
            new RuntimePermission("getClassLoader");

    // java.lang.Thread
    public static final RuntimePermission STOP_THREAD_PERMISSION =
            new RuntimePermission("stopThread");

    // java.lang.Thread
    public static final RuntimePermission GET_STACK_TRACE_PERMISSION =
            new RuntimePermission("getStackTrace");

    // java.lang.Thread
    public static final RuntimePermission SUBCLASS_IMPLEMENTATION_PERMISSION =
            new RuntimePermission("enableContextClassLoaderOverride");

    // java.security.AccessControlContext
    public static final SecurityPermission CREATE_ACC_PERMISSION =
            new SecurityPermission("createAccessControlContext");

    // java.security.AccessControlContext
    public static final SecurityPermission GET_COMBINER_PERMISSION =
            new SecurityPermission("getDomainCombiner");

    // java.security.Policy, java.security.ProtectionDomain
    public static final SecurityPermission GET_POLICY_PERMISSION =
            new SecurityPermission ("getPolicy");

    // java.lang.SecurityManager
    public static final SocketPermission LOCAL_LISTEN_PERMISSION =
            new SocketPermission("localhost:0", SOCKET_LISTEN_ACTION);

    public static final String PROVIDER_VER =
            GetPropertyAction.privilegedGetProperty("java.specification.version");

    // java.lang.reflect.AccessibleObject
    public static final ReflectPermission ACCESS_PERMISSION =
            new ReflectPermission("suppressAccessChecks");

    // sun.reflect.ReflectionFactory
    public static final RuntimePermission REFLECTION_FACTORY_ACCESS_PERMISSION =
            new RuntimePermission("reflectionFactoryAccess");

}
*/
    /*
 class AppleProvider extends Provider {

    private static final String info = "Apple Provider";

    private static final class ProviderService extends Provider.Service {
        ProviderService(Provider p, String type, String algo, String cn) {
            super(p, type, algo, cn, null, null);
        }

        @Override
        public Object newInstance(Object ctrParamObj)
                throws NoSuchAlgorithmException {
            String type = getType();
            if (ctrParamObj != null) {
                throw new InvalidParameterException
                        ("constructorParameter not used with " + type + " engines");
            }

            String algo = getAlgorithm();
            try {
                if (type.equals("KeyStore")) {
                    if (algo.equals("KeychainStore")) {
                        return new KeychainStore();
                    }
                }
            } catch (Exception ex) {
                throw new NoSuchAlgorithmException("Error constructing " +
                        type + " for " + algo + " using Apple", ex);
            }
            throw new ProviderException("No impl for " + algo +
                    " " + type);
        }
    }
/*

    @SuppressWarnings("removal")
    public AppleProvider() {
        super("Apple", PROVIDER_VER, info);

        final Provider p = this;
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                putService(new AppleProvider.ProviderService(p, "KeyStore",
                        "KeychainStore", "apple.security.KeychainStore"));
                return null;
            }
        });
    }
}
*/