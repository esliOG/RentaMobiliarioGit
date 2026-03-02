# Código Fuente de Renta Mobiliario App

Este repositorio contiene todo el código fuente de la aplicación 'Renta Mobiliario'.
A continuación, se presenta cada uno de los archivos que hacen funcionar la app, categorizados y con una explicación clara de lo que hacen, seguido de su código completo.

## Índice de Archivos
- [AndroidManifest.xml](#AndroidManifestxml)
- [java/com/tuempresa/rentaapp/adapters/AdminProductoAdapter.kt](#javacomtuempresarentaappadaptersAdminProductoAdapterkt)
- [java/com/tuempresa/rentaapp/adapters/PedidoAdapter.kt](#javacomtuempresarentaappadaptersPedidoAdapterkt)
- [java/com/tuempresa/rentaapp/adapters/ProductoAdapter.kt](#javacomtuempresarentaappadaptersProductoAdapterkt)
- [java/com/tuempresa/rentaapp/models/FurnitureItem.kt](#javacomtuempresarentaappmodelsFurnitureItemkt)
- [java/com/tuempresa/rentaapp/models/Producto.kt](#javacomtuempresarentaappmodelsProductokt)
- [java/com/tuempresa/rentaapp/models/RentalOrder.kt](#javacomtuempresarentaappmodelsRentalOrderkt)
- [java/com/tuempresa/rentaapp/models/User.kt](#javacomtuempresarentaappmodelsUserkt)
- [java/com/tuempresa/rentaapp/ui/admin/AdminInventarioFragment.kt](#javacomtuempresarentaappuiadminAdminInventarioFragmentkt)
- [java/com/tuempresa/rentaapp/ui/admin/AdminMainActivity.kt](#javacomtuempresarentaappuiadminAdminMainActivitykt)
- [java/com/tuempresa/rentaapp/ui/admin/AdminPedidosFragment.kt](#javacomtuempresarentaappuiadminAdminPedidosFragmentkt)
- [java/com/tuempresa/rentaapp/ui/auth/LoginActivity.kt](#javacomtuempresarentaappuiauthLoginActivitykt)
- [java/com/tuempresa/rentaapp/ui/auth/RegistroActivity.kt](#javacomtuempresarentaappuiauthRegistroActivitykt)
- [java/com/tuempresa/rentaapp/ui/common/PerfilFragment.kt](#javacomtuempresarentaappuicommonPerfilFragmentkt)
- [java/com/tuempresa/rentaapp/ui/user/CatalogoFragment.kt](#javacomtuempresarentaappuiuserCatalogoFragmentkt)
- [java/com/tuempresa/rentaapp/ui/user/ConfirmacionFragment.kt](#javacomtuempresarentaappuiuserConfirmacionFragmentkt)
- [java/com/tuempresa/rentaapp/ui/user/MainActivity.kt](#javacomtuempresarentaappuiuserMainActivitykt)
- [java/com/tuempresa/rentaapp/ui/user/RentasFragment.kt](#javacomtuempresarentaappuiuserRentasFragmentkt)
- [java/com/tuempresa/rentaapp/utils/NotificationHelper.kt](#javacomtuempresarentaapputilsNotificationHelperkt)
- [res/drawable/ic_launcher_background.xml](#resdrawableic_launcher_backgroundxml)
- [res/drawable/ic_launcher_foreground.xml](#resdrawableic_launcher_foregroundxml)
- [res/layout/activity_admin_main.xml](#reslayoutactivity_admin_mainxml)
- [res/layout/activity_login.xml](#reslayoutactivity_loginxml)
- [res/layout/activity_main.xml](#reslayoutactivity_mainxml)
- [res/layout/activity_registro.xml](#reslayoutactivity_registroxml)
- [res/layout/dialog_admin_producto.xml](#reslayoutdialog_admin_productoxml)
- [res/layout/fragment_admin_inventario.xml](#reslayoutfragment_admin_inventarioxml)
- [res/layout/fragment_admin_pedidos.xml](#reslayoutfragment_admin_pedidosxml)
- [res/layout/fragment_catalogo.xml](#reslayoutfragment_catalogoxml)
- [res/layout/fragment_confirmacion.xml](#reslayoutfragment_confirmacionxml)
- [res/layout/fragment_perfil.xml](#reslayoutfragment_perfilxml)
- [res/layout/fragment_rentas.xml](#reslayoutfragment_rentasxml)
- [res/layout/item_admin_producto.xml](#reslayoutitem_admin_productoxml)
- [res/layout/item_pedido.xml](#reslayoutitem_pedidoxml)
- [res/layout/item_producto.xml](#reslayoutitem_productoxml)
- [res/menu/menu_navegacion.xml](#resmenumenu_navegacionxml)
- [res/menu/menu_navegacion_admin.xml](#resmenumenu_navegacion_adminxml)
- [res/mipmap-anydpi-v26/ic_launcher.xml](#resmipmap-anydpi-v26ic_launcherxml)
- [res/mipmap-anydpi-v26/ic_launcher_round.xml](#resmipmap-anydpi-v26ic_launcher_roundxml)
- [res/values-night/themes.xml](#resvalues-nightthemesxml)
- [res/values/colors.xml](#resvaluescolorsxml)
- [res/values/strings.xml](#resvaluesstringsxml)
- [res/values/themes.xml](#resvaluesthemesxml)
- [res/xml/backup_rules.xml](#resxmlbackup_rulesxml)
- [res/xml/data_extraction_rules.xml](#resxmldata_extraction_rulesxml)

---

<a id='AndroidManifestxml'></a>
### Archivo: `AndroidManifest.xml`

**Propósito general:** Es el manifiesto del proyecto, el archivo donde Android lee qué pantallas existen, qué permisos necesita la app y qué configuración general tiene para poder funcionar.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.tuempresa.rentaapp">

    <!-- Permiso para mostrar notificaciones locales (Android 13+) -->
    <uses-permission android:name="android.permission.POST_NOTIFICATIONS" />

    <!-- Visibilidad de paquetes: requerido en Android 11+ para abrir WhatsApp o el navegador -->
    <queries>
        <!-- URLs http / https (para api.whatsapp.com como fallback) -->
        <intent>
            <action android:name="android.intent.action.VIEW" />
            <data android:scheme="https" />
        </intent>
        <intent>
            <action android:name="android.intent.action.VIEW" />
            <data android:scheme="http" />
        </intent>
        <!-- Paquete directo de WhatsApp -->
        <package android:name="com.whatsapp" />
        <!-- WhatsApp Business -->
        <package android:name="com.whatsapp.w4b" />
    </queries>

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.RentaMobiliarioApp">

        <!-- LOGIN (Pantalla inicial) -->
        <activity
            android:name=".ui.auth.LoginActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

        <!-- MAIN -->
        <activity
            android:name=".ui.user.MainActivity"
            android:exported="false" />

        <!-- ADMIN MAIN -->
        <activity
            android:name=".ui.admin.AdminMainActivity"
            android:exported="false" />

        <!-- REGISTRO -->
        <activity
            android:name=".ui.auth.RegistroActivity"
            android:exported="false" />

    </application>

</manifest>
```

---

<a id='javacomtuempresarentaappadaptersAdminProductoAdapterkt'></a>
### Archivo: `java/com/tuempresa/rentaapp/adapters/AdminProductoAdapter.kt`

**Propósito general:** Los adaptadores (adapters) son los encargados de tomar las listas de datos (como el catálogo o tus rentas) y mostrarlas en los RecyclerViews de la pantalla. Toman cada elemento de la lista y lo acomodan en su diseño correspondiente visualmente.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```kotlin
package com.tuempresa.rentaapp.adapters

import com.tuempresa.rentaapp.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tuempresa.rentaapp.models.FurnitureItem

class AdminProductoAdapter(
    private var productos: List<FurnitureItem>,
    private val onEditClick: (FurnitureItem) -> Unit,
    private val onDeleteClick: (FurnitureItem) -> Unit
) : RecyclerView.Adapter<AdminProductoAdapter.AdminViewHolder>() {

    class AdminViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNombre: TextView = view.findViewById(R.id.tvAdminNombreProd)
        val tvDesc: TextView = view.findViewById(R.id.tvAdminDescProd)
        val tvPrecio: TextView = view.findViewById(R.id.tvAdminPrecioProd)
        val tvStock: TextView = view.findViewById(R.id.tvAdminStockProd)
        val btnEditar: Button = view.findViewById(R.id.btnAdminEditar)
        val btnEliminar: Button = view.findViewById(R.id.btnAdminEliminar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_admin_producto, parent, false)
        return AdminViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdminViewHolder, position: Int) {
        val producto = productos[position]

        holder.tvNombre.text = producto.nombreProducto
        holder.tvDesc.text = producto.descripcion
        holder.tvPrecio.text = "$${producto.precio}"
        holder.tvStock.text = "Stock: ${producto.totalStock} (Disp: ${producto.existencia})"

        holder.btnEditar.setOnClickListener { onEditClick(producto) }
        holder.btnEliminar.setOnClickListener { onDeleteClick(producto) }
    }

    override fun getItemCount(): Int = productos.size

    fun actualizarLista(nuevaLista: List<FurnitureItem>) {
        productos = nuevaLista
        notifyDataSetChanged()
    }
}

```

---

<a id='javacomtuempresarentaappadaptersPedidoAdapterkt'></a>
### Archivo: `java/com/tuempresa/rentaapp/adapters/PedidoAdapter.kt`

**Propósito general:** Los adaptadores (adapters) son los encargados de tomar las listas de datos (como el catálogo o tus rentas) y mostrarlas en los RecyclerViews de la pantalla. Toman cada elemento de la lista y lo acomodan en su diseño correspondiente visualmente.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```kotlin
package com.tuempresa.rentaapp.adapters

import com.tuempresa.rentaapp.R

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tuempresa.rentaapp.models.OrderStatus
import com.tuempresa.rentaapp.models.RentalOrder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class PedidoAdapter(
    private var pedidos: List<RentalOrder>,
    private val esAdmin: Boolean,
    private val onEstadoCambiado: ((RentalOrder, OrderStatus) -> Unit)? = null
) : RecyclerView.Adapter<PedidoAdapter.PedidoViewHolder>() {

    class PedidoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvId: TextView = view.findViewById(R.id.tvPedidoId)
        val tvEstado: TextView = view.findViewById(R.id.tvPedidoEstado)
        val tvFechas: TextView = view.findViewById(R.id.tvPedidoFechas)
        val tvTotal: TextView = view.findViewById(R.id.tvPedidoTotal)
        val tvItems: TextView = view.findViewById(R.id.tvPedidoItems)
        val llAdmin: LinearLayout = view.findViewById(R.id.llAdminControles)
        val separator: View = view.findViewById(R.id.viewSeparador)
        val btnDevuelto: Button = view.findViewById(R.id.btnMarcarDevuelto)
        val btnCancelado: Button = view.findViewById(R.id.btnMarcarCancelado)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PedidoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pedido, parent, false)
        return PedidoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PedidoViewHolder, position: Int) {
        val pedido = pedidos[position]

        holder.tvId.text = "Pedido #${pedido.id.take(6).uppercase()}"
        holder.tvTotal.text = "Total: $${pedido.totalCost}"

        holder.tvEstado.text = pedido.status.name
        when (pedido.status) {
            OrderStatus.PENDING -> holder.tvEstado.setTextColor(Color.parseColor("#FF9800"))
            OrderStatus.APPROVED -> holder.tvEstado.setTextColor(Color.parseColor("#2196F3"))
            OrderStatus.IN_PROGRESS -> holder.tvEstado.setTextColor(Color.parseColor("#9C27B0"))
            OrderStatus.RETURNED -> holder.tvEstado.setTextColor(Color.parseColor("#4CAF50"))
            OrderStatus.CANCELLED -> holder.tvEstado.setTextColor(Color.RED)
        }

        val sdf = SimpleDateFormat("dd/MM/yy", Locale.getDefault())
        val fe = sdf.format(Date(pedido.deliveryDate))
        val fd = sdf.format(Date(pedido.returnDate))
        holder.tvFechas.text = "Entrega: $fe  |  Devolución: $fd"

        // Mostrar sumario de items expandido 
        var cants = "Artículos:"
        pedido.items.forEach { 
            // Podríamos consultar el nombre a Firestore, pero por simplicidad mostramos ID
            cants += "\n- ${it.quantity}x articulo (ID:${it.furnitureId.take(4)})"
        }
        holder.tvItems.text = cants
        holder.tvItems.visibility = View.VISIBLE

        if (esAdmin) {
            holder.llAdmin.visibility = View.VISIBLE
            holder.separator.visibility = View.VISIBLE

            // Solo mostrar controles si NO ha sido cerrado
            if (pedido.status == OrderStatus.RETURNED || pedido.status == OrderStatus.CANCELLED) {
                holder.btnDevuelto.visibility = View.GONE
                holder.btnCancelado.visibility = View.GONE
            } else {
                holder.btnDevuelto.visibility = View.VISIBLE
                holder.btnCancelado.visibility = View.VISIBLE
            }

            holder.btnDevuelto.setOnClickListener { onEstadoCambiado?.invoke(pedido, OrderStatus.RETURNED) }
            holder.btnCancelado.setOnClickListener { onEstadoCambiado?.invoke(pedido, OrderStatus.CANCELLED) }

            // Permite marcar aprobado (solo visual temporal)
            holder.itemView.setOnLongClickListener {
                 if (pedido.status == OrderStatus.PENDING) {
                     onEstadoCambiado?.invoke(pedido, OrderStatus.APPROVED)
                 }
                 true
            }
        }
    }

    override fun getItemCount(): Int = pedidos.size

    fun actualizarLista(nuevaLista: List<RentalOrder>) {
        pedidos = nuevaLista
        notifyDataSetChanged()
    }
}

```

---

<a id='javacomtuempresarentaappadaptersProductoAdapterkt'></a>
### Archivo: `java/com/tuempresa/rentaapp/adapters/ProductoAdapter.kt`

**Propósito general:** Los adaptadores (adapters) son los encargados de tomar las listas de datos (como el catálogo o tus rentas) y mostrarlas en los RecyclerViews de la pantalla. Toman cada elemento de la lista y lo acomodan en su diseño correspondiente visualmente.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```kotlin
package com.tuempresa.rentaapp.adapters

import com.tuempresa.rentaapp.R

import com.tuempresa.rentaapp.models.Producto

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductoAdapter(
    private val lista: List<Producto>,
    private val listener: OnCantidadChangeListener
) : RecyclerView.Adapter<ProductoAdapter.ViewHolder>() {

    interface OnCantidadChangeListener {
        fun onCantidadChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre: TextView = view.findViewById(R.id.tvNombre)
        val descripcion: TextView = view.findViewById(R.id.tvDescripcion)
        val precio: TextView = view.findViewById(R.id.tvPrecio)
        val stockDisp: TextView = view.findViewById(R.id.tvStockDisponible)
        val cantidad: TextView = view.findViewById(R.id.tvCantidad)
        val btnMas: Button = view.findViewById(R.id.btnMas)
        val btnMenos: Button = view.findViewById(R.id.btnMenos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = lista[position]
        val item = p.furniture

        holder.nombre.text = item.nombreProducto
        holder.descripcion.text = item.descripcion
        holder.precio.text = "$${item.precio}"
        
        holder.stockDisp.text = "Disponibles: ${item.existencia}"
        if (item.existencia == 0) {
            holder.stockDisp.setTextColor(Color.RED)
            holder.stockDisp.text = "Agotado"
        } else {
            holder.stockDisp.setTextColor(Color.parseColor("#4CAF50"))
        }

        holder.cantidad.text = p.cantidadSeleccionada.toString()

        holder.btnMas.setOnClickListener {
            if (p.cantidadSeleccionada < item.existencia) {
                p.cantidadSeleccionada++
                holder.cantidad.text = p.cantidadSeleccionada.toString()
                listener.onCantidadChanged()
            }
        }

        holder.btnMenos.setOnClickListener {
            if (p.cantidadSeleccionada > 0) {
                p.cantidadSeleccionada--
                holder.cantidad.text = p.cantidadSeleccionada.toString()
                listener.onCantidadChanged()
            }
        }
    }

    override fun getItemCount() = lista.size
}

```

---

<a id='javacomtuempresarentaappmodelsFurnitureItemkt'></a>
### Archivo: `java/com/tuempresa/rentaapp/models/FurnitureItem.kt`

**Propósito general:** Este paquete define las estructuras de datos, o 'modelos', que se usan en todo el proyecto. Básicamente, son los moldes para crear objetos como usuarios, muebles y pedidos, facilitando el guardar y leer datos de Firebase.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```kotlin
package com.tuempresa.rentaapp.models

data class FurnitureItem(
    val id: String = "",
    val nombreProducto: String = "",
    val descripcion: String = "",
    val precio: Double = 0.0,
    val totalStock: Int = 0,
    val existencia: Int = 0,
    val imageUrl: String = ""
)

```

---

<a id='javacomtuempresarentaappmodelsProductokt'></a>
### Archivo: `java/com/tuempresa/rentaapp/models/Producto.kt`

**Propósito general:** Este paquete define las estructuras de datos, o 'modelos', que se usan en todo el proyecto. Básicamente, son los moldes para crear objetos como usuarios, muebles y pedidos, facilitando el guardar y leer datos de Firebase.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```kotlin
package com.tuempresa.rentaapp.models

import com.tuempresa.rentaapp.models.FurnitureItem
import java.io.Serializable

data class Producto(
    val furniture: FurnitureItem,
    var cantidadSeleccionada: Int = 0
) : Serializable

```

---

<a id='javacomtuempresarentaappmodelsRentalOrderkt'></a>
### Archivo: `java/com/tuempresa/rentaapp/models/RentalOrder.kt`

**Propósito general:** Este paquete define las estructuras de datos, o 'modelos', que se usan en todo el proyecto. Básicamente, son los moldes para crear objetos como usuarios, muebles y pedidos, facilitando el guardar y leer datos de Firebase.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```kotlin
package com.tuempresa.rentaapp.models

data class RentalOrder(
    val id: String = "",
    val userId: String = "",
    val items: List<CartItem> = emptyList(),
    val deliveryDate: Long = 0L,
    val returnDate: Long = 0L,
    val status: OrderStatus = OrderStatus.PENDING,
    val paymentStatus: PaymentStatus = PaymentStatus.PENDING,
    val totalCost: Double = 0.0,
    val paymentMethod: String = ""
)

data class CartItem(
    val furnitureId: String = "",
    val quantity: Int = 0,
    val pricePerItem: Double = 0.0
)

enum class OrderStatus {
    PENDING,
    APPROVED,
    IN_PROGRESS,
    RETURNED,
    CANCELLED
}

enum class PaymentStatus {
    PENDING,
    PAID,
    REFUNDED
}

```

---

<a id='javacomtuempresarentaappmodelsUserkt'></a>
### Archivo: `java/com/tuempresa/rentaapp/models/User.kt`

**Propósito general:** Este paquete define las estructuras de datos, o 'modelos', que se usan en todo el proyecto. Básicamente, son los moldes para crear objetos como usuarios, muebles y pedidos, facilitando el guardar y leer datos de Firebase.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```kotlin
package com.tuempresa.rentaapp.models

data class User(
    val id: String = "",
    val nombreUsuario: String = "",
    val email: String = "",
    val telefono: String = "",
    val role: Role = Role.CLIENTE
)

enum class Role {
    CLIENTE, ADMINISTRADOR
}

```

---

<a id='javacomtuempresarentaappuiadminAdminInventarioFragmentkt'></a>
### Archivo: `java/com/tuempresa/rentaapp/ui/admin/AdminInventarioFragment.kt`

**Propósito general:** Estas pantallas son exclusivas para los administradores. Tienen el control total sobre el inventario, permitiendo agregar, editar o borrar muebles, además de procesar los pedidos de los clientes (cambiarlos a devueltos, cancelados, etc).

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```kotlin
package com.tuempresa.rentaapp.ui.admin

import com.tuempresa.rentaapp.R

import com.tuempresa.rentaapp.models.Producto
import com.tuempresa.rentaapp.adapters.AdminProductoAdapter

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.tuempresa.rentaapp.databinding.FragmentAdminInventarioBinding
import com.tuempresa.rentaapp.models.FurnitureItem
import java.util.UUID

class AdminInventarioFragment : Fragment() {

    private var _binding: FragmentAdminInventarioBinding? = null
    // Evitamos el crash si viewBinding falla, aunque en onCreate validaremos su inflado.
    private val binding get() = _binding!! 

    private val db = FirebaseFirestore.getInstance()
    private lateinit var adapter: AdminProductoAdapter
    private var listaMobiliario = mutableListOf<FurnitureItem>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAdminInventarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = AdminProductoAdapter(
            productos = listaMobiliario,
            onEditClick = { producto -> mostrarDialogoProducto(producto) },
            onDeleteClick = { producto -> confirmarEliminacion(producto) }
        )

        binding.rvAdminProductos.layoutManager = LinearLayoutManager(context)
        binding.rvAdminProductos.adapter = adapter

        binding.fabAgregarProducto.setOnClickListener {
            mostrarDialogoProducto(null)
        }

        cargarInventario()
    }

    private fun cargarInventario() {
        db.collection("mobiliario").addSnapshotListener { snapshot, e ->
            if (e != null) {
                Toast.makeText(context, "Error al cargar catálogo", Toast.LENGTH_SHORT).show()
                return@addSnapshotListener
            }

            if (snapshot != null) {
                listaMobiliario.clear()
                for (doc in snapshot.documents) {
                    val item = doc.toObject(FurnitureItem::class.java)
                    if (item != null) {
                        listaMobiliario.add(item)
                    }
                }
                adapter.actualizarLista(listaMobiliario)
            }
        }
    }

    private fun mostrarDialogoProducto(productoExistente: FurnitureItem?) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_admin_producto, null)
        
        val tvTitulo = dialogView.findViewById<TextView>(R.id.tvDialogTitulo)
        val etNombre = dialogView.findViewById<EditText>(R.id.etDialogNombre)
        val etDesc = dialogView.findViewById<EditText>(R.id.etDialogDesc)
        val etPrecio = dialogView.findViewById<EditText>(R.id.etDialogPrecio)
        val etStock = dialogView.findViewById<EditText>(R.id.etDialogStock)
        val btnCancelar = dialogView.findViewById<Button>(R.id.btnDialogCancelar)
        val btnGuardar = dialogView.findViewById<Button>(R.id.btnDialogGuardar)

        if (productoExistente != null) {
            tvTitulo.text = "Editar Producto"
            etNombre.setText(productoExistente.nombreProducto)
            etDesc.setText(productoExistente.descripcion)
            etPrecio.setText(productoExistente.precio.toString())
            etStock.setText(productoExistente.totalStock.toString())
        } else {
            tvTitulo.text = "Agregar Producto"
        }

        val dialog = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .setCancelable(false)
            .create()

        btnCancelar.setOnClickListener { dialog.dismiss() }

        btnGuardar.setOnClickListener {
            val name = etNombre.text.toString().trim()
            val desc = etDesc.text.toString().trim()
            val priceStr = etPrecio.text.toString().trim()
            val stockStr = etStock.text.toString().trim()

            if (name.isEmpty() || desc.isEmpty() || priceStr.isEmpty() || stockStr.isEmpty()) {
                Toast.makeText(context, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val price = priceStr.toDoubleOrNull() ?: 0.0
            val totalStock = stockStr.toIntOrNull() ?: 0

            val id = productoExistente?.id ?: UUID.randomUUID().toString()
            
            // Si es nuevo, available == total. Si se edita, calculamos la diferencia.
            val availableStock = if (productoExistente != null) {
                val diferencia = totalStock - productoExistente.totalStock
                productoExistente.existencia + diferencia
            } else {
                totalStock
            }

            val nuevoProducto = FurnitureItem(
                id = id,
                nombreProducto = name,
                descripcion = desc,
                precio = price,
                totalStock = totalStock,
                existencia = availableStock,
                imageUrl = productoExistente?.imageUrl ?: ""
            )

            guardarEnFirestore(nuevoProducto)
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun guardarEnFirestore(producto: FurnitureItem) {
        db.collection("mobiliario").document(producto.id).set(producto)
            .addOnSuccessListener {
                Toast.makeText(context, "Producto guardado", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(context, "Error al guardar", Toast.LENGTH_SHORT).show()
            }
    }

    private fun confirmarEliminacion(producto: FurnitureItem) {
        AlertDialog.Builder(requireContext())
            .setTitle("Eliminar Producto")
            .setMessage("¿Estás seguro de que deseas eliminar '${producto.nombreProducto}' del catálogo?")
            .setPositiveButton("Eliminar") { _, _ ->
                db.collection("mobiliario").document(producto.id).delete()
                    .addOnSuccessListener {
                        Toast.makeText(context, "Producto eliminado", Toast.LENGTH_SHORT).show()
                    }
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

```

---

<a id='javacomtuempresarentaappuiadminAdminMainActivitykt'></a>
### Archivo: `java/com/tuempresa/rentaapp/ui/admin/AdminMainActivity.kt`

**Propósito general:** Estas pantallas son exclusivas para los administradores. Tienen el control total sobre el inventario, permitiendo agregar, editar o borrar muebles, además de procesar los pedidos de los clientes (cambiarlos a devueltos, cancelados, etc).

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```kotlin
package com.tuempresa.rentaapp.ui.admin

import com.tuempresa.rentaapp.R
import com.tuempresa.rentaapp.ui.common.PerfilFragment
import com.tuempresa.rentaapp.utils.NotificationHelper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.tuempresa.rentaapp.databinding.ActivityAdminMainBinding

class AdminMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminMainBinding

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private var notifListener: ListenerRegistration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NotificationHelper.createChannel(this)

        // Cargar fragment inicial
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedor_fragmentos, AdminInventarioFragment())
                .commit()
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.nav_admin_inventario -> AdminInventarioFragment()
                R.id.nav_admin_pedidos -> AdminPedidosFragment()
                R.id.nav_perfil -> PerfilFragment()
                else -> null
            }
            fragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.contenedor_fragmentos, it)
                    .commit()
            }
            true
        }

        // Escuchar notificaciones de Firestore dirigidas al rol ADMINISTRADOR
        escucharNotificaciones()
    }

    private fun escucharNotificaciones() {
        notifListener = db.collection("notificaciones")
            .whereEqualTo("paraRol", "ADMINISTRADOR")
            .whereEqualTo("leido", false)
            .addSnapshotListener { snapshot, e ->
                if (e != null || snapshot == null) return@addSnapshotListener
                for (doc in snapshot.documents) {
                    val titulo = doc.getString("titulo") ?: "Notificación"
                    val cuerpo = doc.getString("cuerpo") ?: ""
                    NotificationHelper.mostrar(this, titulo, cuerpo)
                    // Marcar como leído para no volver a mostrarlo
                    doc.reference.update("leido", true)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        notifListener?.remove()
    }
}

```

---

<a id='javacomtuempresarentaappuiadminAdminPedidosFragmentkt'></a>
### Archivo: `java/com/tuempresa/rentaapp/ui/admin/AdminPedidosFragment.kt`

**Propósito general:** Estas pantallas son exclusivas para los administradores. Tienen el control total sobre el inventario, permitiendo agregar, editar o borrar muebles, además de procesar los pedidos de los clientes (cambiarlos a devueltos, cancelados, etc).

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```kotlin
package com.tuempresa.rentaapp.ui.admin

import com.tuempresa.rentaapp.adapters.PedidoAdapter

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.tuempresa.rentaapp.databinding.FragmentAdminPedidosBinding
import com.tuempresa.rentaapp.models.OrderStatus
import com.tuempresa.rentaapp.models.RentalOrder
import com.tuempresa.rentaapp.utils.NotificationHelper

class AdminPedidosFragment : Fragment() {

    private var _binding: FragmentAdminPedidosBinding? = null
    private val binding get() = _binding!!

    private val db = FirebaseFirestore.getInstance()
    private lateinit var adapter: PedidoAdapter
    private var listaPedidos = mutableListOf<RentalOrder>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdminPedidosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PedidoAdapter(listaPedidos, esAdmin = true) { pedido, nuevoEstado ->
            if (nuevoEstado == OrderStatus.APPROVED) {
                actualizarEstadoPedido(pedido, nuevoEstado)
            } else {
                confirmarCambioEstado(pedido, nuevoEstado)
            }
        }

        binding.rvAdminPedidos.layoutManager = LinearLayoutManager(context)
        binding.rvAdminPedidos.adapter = adapter

        cargarTodosLosPedidos()
    }

    private fun cargarTodosLosPedidos() {
        db.collection("rentas")
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Toast.makeText(context, "Error cargando pedidos", Toast.LENGTH_SHORT).show()
                    return@addSnapshotListener
                }
                if (snapshot != null) {
                    listaPedidos.clear()
                    for (doc in snapshot.documents) {
                        val pedido = doc.toObject(RentalOrder::class.java)
                        if (pedido != null) listaPedidos.add(pedido)
                    }
                    listaPedidos.sortByDescending { it.deliveryDate }
                    adapter.actualizarLista(listaPedidos)
                }
            }
    }

    private fun confirmarCambioEstado(pedido: RentalOrder, nuevoEstado: OrderStatus) {
        val accion = if (nuevoEstado == OrderStatus.RETURNED) "Marcar como DEVUELTO" else "CANCELAR pedido"
        AlertDialog.Builder(requireContext())
            .setTitle(accion)
            .setMessage("¿Estás seguro que deseas $accion #${pedido.id.take(6).uppercase()}?\n\nEsto regresará los artículos al stock disponible.")
            .setPositiveButton("Sí, proceder") { _, _ ->
                procesarDevolucionStock(pedido, nuevoEstado)
            }
            .setNegativeButton("Cerrar", null)
            .show()
    }

    private fun procesarDevolucionStock(pedido: RentalOrder, nuevoEstado: OrderStatus) {
        // Transacción Firestore: PRIMERO todas las lecturas, LUEGO todas las escrituras
        db.runTransaction { transaction ->

            // ── FASE 1: TODAS las lecturas ──────────────────────────────────────────
            val snapshots = pedido.items.map { cartItem ->
                val docRef = db.collection("mobiliario").document(cartItem.furnitureId)
                Pair(cartItem, transaction.get(docRef))
            }

            // ── FASE 2: TODAS las escrituras (stock + estado pedido) ───────────────
            snapshots.forEach { (cartItem, snapshot) ->
                if (snapshot.exists()) {
                    val stockActual = snapshot.getLong("existencia") ?: 0
                    val docRef = db.collection("mobiliario").document(cartItem.furnitureId)
                    transaction.update(docRef, "existencia", stockActual + cartItem.quantity)
                }
            }

            val orderRef = db.collection("rentas").document(pedido.id)
            transaction.update(orderRef, "status", nuevoEstado.name)

            null
        }.addOnSuccessListener {
            val estadoTexto = when (nuevoEstado) {
                OrderStatus.RETURNED -> "devuelto"
                OrderStatus.CANCELLED -> "cancelado"
                else -> nuevoEstado.name.lowercase()
            }

            // Notificación local al admin
            NotificationHelper.mostrar(
                requireContext(),
                "✅ Pedido Actualizado",
                "Pedido #${pedido.id.take(6).uppercase()} marcado como $estadoTexto. Stock recuperado."
            )

            // Notificación Firestore para el usuario dueño del pedido
            enviarNotificacionFirestore(
                paraUserId = pedido.userId,
                titulo = when (nuevoEstado) {
                    OrderStatus.RETURNED -> "📦 Renta Completada"
                    OrderStatus.CANCELLED -> "❌ Renta Cancelada"
                    else -> "🔄 Estado Actualizado"
                },
                cuerpo = "Tu pedido #${pedido.id.take(6).uppercase()} fue $estadoTexto."
            )

            Toast.makeText(context, "Estado actualizado y stock recuperado", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener { e ->
            Toast.makeText(context, "Error al actualizar: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun actualizarEstadoPedido(pedido: RentalOrder, nuevoEstado: OrderStatus) {
        db.collection("rentas").document(pedido.id)
            .update("status", nuevoEstado.name)
            .addOnSuccessListener {
                // Notificación local al admin
                NotificationHelper.mostrar(
                    requireContext(),
                    "✅ Pedido Aprobado",
                    "Pedido #${pedido.id.take(6).uppercase()} marcado como Aprobado."
                )

                // Notificación Firestore para el usuario
                enviarNotificacionFirestore(
                    paraUserId = pedido.userId,
                    titulo = "🎉 Renta Aprobada",
                    cuerpo = "Tu pedido #${pedido.id.take(6).uppercase()} fue aprobado. ¡Te esperamos!"
                )

                Toast.makeText(context, "Pedido marcado como Aprobado", Toast.LENGTH_SHORT).show()
            }
    }

    /**
     * Escribe un documento en "notificaciones" en Firestore.
     * El listener en MainActivity lo leerá y mostrará la notif local al usuario.
     */
    private fun enviarNotificacionFirestore(
        paraUserId: String,
        titulo: String,
        cuerpo: String
    ) {
        val notif = hashMapOf(
            "paraRol" to null,
            "paraUserId" to paraUserId,
            "titulo" to titulo,
            "cuerpo" to cuerpo,
            "leido" to false,
            "timestamp" to System.currentTimeMillis()
        )
        db.collection("notificaciones").add(notif)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

```

---

<a id='javacomtuempresarentaappuiauthLoginActivitykt'></a>
### Archivo: `java/com/tuempresa/rentaapp/ui/auth/LoginActivity.kt`

**Propósito general:** El área de autenticación. Aquí está la lógica para el inicio de sesión y el registro de nuevos usuarios usando Firebase Auth. Asegura que cada quien entre a la parte de la app que le toca según su rol.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```kotlin
package com.tuempresa.rentaapp.ui.auth

import com.tuempresa.rentaapp.ui.admin.AdminMainActivity
import com.tuempresa.rentaapp.ui.user.MainActivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.tuempresa.rentaapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        // Si ya hay sesión activa, ir directo al menú y cerrar login
        if (auth.currentUser != null) {
            irAlMenuPrincipal()
            return
        }

        binding.btnContinuar.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Ingresa tu correo y contraseña", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            iniciarSesion(email, password)
        }

        binding.tvIrAlRegistro.setOnClickListener {
            startActivity(Intent(this, RegistroActivity::class.java))
            finish()
        }
    }

    private fun iniciarSesion(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    irAlMenuPrincipal()
                } else {
                    Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun irAlMenuPrincipal() {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val db = com.google.firebase.firestore.FirebaseFirestore.getInstance()
            db.collection("usuarios").document(currentUser.uid).get()
                .addOnSuccessListener { document ->
                    if (document.exists() && document.getString("role") == "ADMINISTRADOR") {
                        startActivity(Intent(this, AdminMainActivity::class.java))
                    } else {
                        startActivity(Intent(this, MainActivity::class.java))
                    }
                    finish()
                }
                .addOnFailureListener {
                    // Fallback to client if failure
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
        }
    }
}

```

---

<a id='javacomtuempresarentaappuiauthRegistroActivitykt'></a>
### Archivo: `java/com/tuempresa/rentaapp/ui/auth/RegistroActivity.kt`

**Propósito general:** El área de autenticación. Aquí está la lógica para el inicio de sesión y el registro de nuevos usuarios usando Firebase Auth. Asegura que cada quien entre a la parte de la app que le toca según su rol.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```kotlin
package com.tuempresa.rentaapp.ui.auth

import com.tuempresa.rentaapp.ui.admin.AdminMainActivity
import com.tuempresa.rentaapp.ui.user.MainActivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tuempresa.rentaapp.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.tuempresa.rentaapp.models.Role
import com.tuempresa.rentaapp.models.User

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding
    private lateinit var auth: FirebaseAuth
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        // Si ya hay un usuario logueado, ir directo
        if (auth.currentUser != null) {
            irAlMenuPrincipal()
            return
        }

        binding.btnRegistrar.setOnClickListener {
            val nombre = binding.etNombre.text.toString().trim()
            val telefono = binding.etTelefono.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val esAdmin = binding.switchAdminRole.isChecked

            if (nombre.isEmpty() || telefono.length < 10 || email.isEmpty() || password.length < 6) {
                Toast.makeText(this, "Por favor completa todos los campos correctamente", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            registrarUsuarioEnFirebase(nombre, telefono, email, password, esAdmin)
        }

        binding.tvIrAlLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun registrarUsuarioEnFirebase(nombre: String, telefono: String, email: String, password: String, esAdmin: Boolean) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val firebaseUser = auth.currentUser
                    if (firebaseUser != null) {
                        guardarDatosUsuario(firebaseUser.uid, nombre, email, telefono, esAdmin)
                    }
                } else {
                    Toast.makeText(this, "Error de registro: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun guardarDatosUsuario(uid: String, nombre: String, email: String, telefono: String, esAdmin: Boolean) {
        val rolElegido = if (esAdmin) Role.ADMINISTRADOR else Role.CLIENTE
        val user = User(
            id = uid,
            nombreUsuario = nombre,
            email = email,
            telefono = telefono,
            role = rolElegido
        )

        db.collection("usuarios").document(uid).set(user)
            .addOnSuccessListener {
                Toast.makeText(this, "¡Bienvenido $nombre!", Toast.LENGTH_SHORT).show()
                irAlMenuPrincipal()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error guardando datos: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun irAlMenuPrincipal() {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            db.collection("usuarios").document(currentUser.uid).get()
                .addOnSuccessListener { document ->
                    if (document.exists() && document.getString("role") == "ADMINISTRADOR") {
                        startActivity(Intent(this, AdminMainActivity::class.java))
                    } else {
                        startActivity(Intent(this, MainActivity::class.java))
                    }
                    finish()
                }
                .addOnFailureListener {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
        }
    }
}

```

---

<a id='javacomtuempresarentaappuicommonPerfilFragmentkt'></a>
### Archivo: `java/com/tuempresa/rentaapp/ui/common/PerfilFragment.kt`

**Propósito general:** Este es uno de los archivos de configuración o recursos base que necesita Android Studio para compilar el proyecto correctamente.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```kotlin
package com.tuempresa.rentaapp.ui.common

import com.tuempresa.rentaapp.ui.auth.LoginActivity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.tuempresa.rentaapp.databinding.FragmentPerfilBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PerfilFragment : Fragment() {

    private var _binding: FragmentPerfilBinding? = null
    private val binding get() = _binding!!

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cargarDatosUsuario()

        binding.btnGuardarPerfil.setOnClickListener {
            guardarDatosUsuario()
        }

        binding.btnCerrarSesion.setOnClickListener {
            auth.signOut()
            val intent = Intent(requireContext(), LoginActivity::class.java)
            // Clear entire task stack so user can't press back to go back into the app
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    private fun cargarDatosUsuario() {
        val userId = auth.currentUser?.uid ?: return

        db.collection("usuarios").document(userId).get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    binding.etNombrePerfil.setText(document.getString("nombreUsuario"))
                    binding.etTelefonoPerfil.setText(document.getString("telefono"))
                    binding.etEmailPerfil.setText(document.getString("email"))
                }
            }
            .addOnFailureListener {
                Toast.makeText(context, "Error cargando perfil", Toast.LENGTH_SHORT).show()
            }
    }

    private fun guardarDatosUsuario() {
        val userId = auth.currentUser?.uid ?: return
        val nuevoNombre = binding.etNombrePerfil.text.toString().trim()
        val nuevoTelefono = binding.etTelefonoPerfil.text.toString().trim()

        if (nuevoNombre.isEmpty() || nuevoTelefono.isEmpty()) {
            Toast.makeText(context, "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show()
            return
        }

        val updates = mapOf(
            "nombreUsuario" to nuevoNombre,
            "telefono" to nuevoTelefono
        )

        db.collection("usuarios").document(userId).update(updates)
            .addOnSuccessListener {
                Toast.makeText(context, "Perfil actualizado", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(context, "Error al actualizar: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

```

---

<a id='javacomtuempresarentaappuiuserCatalogoFragmentkt'></a>
### Archivo: `java/com/tuempresa/rentaapp/ui/user/CatalogoFragment.kt`

**Propósito general:** Aquí es donde vive casi todo lo que ve el cliente final. Contiene las pantallas principales (Fragments y Activities) para navegar por el catálogo, ver los detalles, armar el carrito de rentas y ver el historial de pedidos personales.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```kotlin
package com.tuempresa.rentaapp.ui.user

import com.tuempresa.rentaapp.models.Producto
import com.tuempresa.rentaapp.adapters.ProductoAdapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.tuempresa.rentaapp.databinding.FragmentCatalogoBinding
import com.tuempresa.rentaapp.models.FurnitureItem

class CatalogoFragment : Fragment(), ProductoAdapter.OnCantidadChangeListener {

    private var _binding: FragmentCatalogoBinding? = null
    private val binding get() = _binding!!

    private var listaWrapperProductos = mutableListOf<Producto>()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatalogoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvProductos.layoutManager = LinearLayoutManager(requireContext())

        binding.btnConfirmarRenta.setOnClickListener {
            val seleccionados = listaWrapperProductos.filter { it.cantidadSeleccionada > 0 }

            if (seleccionados.isEmpty()) {
                Toast.makeText(requireContext(), "Selecciona al menos un producto", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            (activity as? MainActivity)?.irConfirmacion(seleccionados)
                ?: Toast.makeText(requireContext(), "Error de navegación", Toast.LENGTH_SHORT).show()
        }

        consultarProductos()
    }

    private fun consultarProductos() {
        db.collection("mobiliario")
            .whereGreaterThan("totalStock", 0) // No mostrar cosas dadas de baja
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    Toast.makeText(requireContext(), "Error al cargar catálogo", Toast.LENGTH_SHORT).show()
                    return@addSnapshotListener
                }

                if (snapshot != null) {
                    listaWrapperProductos.clear()
                    for (doc in snapshot.documents) {
                        val item = doc.toObject(FurnitureItem::class.java)
                        if (item != null) {
                            listaWrapperProductos.add(Producto(furniture = item, cantidadSeleccionada = 0))
                        }
                    }
                    binding.rvProductos.adapter = ProductoAdapter(listaWrapperProductos, this)
                }
            }
    }

    override fun onCantidadChanged() {
        (activity as? MainActivity)?.actualizarTotal(listaWrapperProductos)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

```

---

<a id='javacomtuempresarentaappuiuserConfirmacionFragmentkt'></a>
### Archivo: `java/com/tuempresa/rentaapp/ui/user/ConfirmacionFragment.kt`

**Propósito general:** Aquí es donde vive casi todo lo que ve el cliente final. Contiene las pantallas principales (Fragments y Activities) para navegar por el catálogo, ver los detalles, armar el carrito de rentas y ver el historial de pedidos personales.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```kotlin
package com.tuempresa.rentaapp.ui.user

import com.tuempresa.rentaapp.models.Producto
import com.tuempresa.rentaapp.R

import android.Manifest
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.tuempresa.rentaapp.databinding.FragmentConfirmacionBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.tuempresa.rentaapp.models.CartItem
import com.tuempresa.rentaapp.models.OrderStatus
import com.tuempresa.rentaapp.models.PaymentStatus
import com.tuempresa.rentaapp.models.RentalOrder
import com.tuempresa.rentaapp.utils.NotificationHelper
import java.util.*

class ConfirmacionFragment : Fragment() {

    private var _binding: FragmentConfirmacionBinding? = null
    private val binding get() = _binding!!

    private lateinit var listaProductos: ArrayList<Producto>
    private var total: Double = 0.0

    private var fechaEntregaMs: Long = 0L
    private var fechaDevolucionMs: Long = 0L

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    // Launcher para pedir permiso de notificaciones (Android 13+)
    private val notifPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { /* no-op: el usuario puede denegar, no bloqueamos la acción */ }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listaProductos = arguments?.getSerializable("productos") as? ArrayList<Producto> ?: arrayListOf()
        total = calcularTotal()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConfirmacionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Solicitar permiso de notificaciones si es Android 13+
        pedirPermisoNotificaciones()

        binding.tvTotalConfirmacion.text = "Total a pagar: \$$total"

        var resumen = "Artículos rentados:\n\n"
        listaProductos.forEach {
            resumen += "- ${it.cantidadSeleccionada}x ${it.furniture.nombreProducto} (\$${it.furniture.precio} c/u)\n"
        }
        binding.tvResumenArticulos.text = resumen

        binding.btnFechaEntrega.setOnClickListener {
            mostrarDatePicker { timestamp, fechaString ->
                fechaEntregaMs = timestamp
                binding.btnFechaEntrega.text = "Entrega: $fechaString"
            }
        }

        binding.btnFechaDevolucion.setOnClickListener {
            mostrarDatePicker { timestamp, fechaString ->
                fechaDevolucionMs = timestamp
                binding.btnFechaDevolucion.text = "Devolución: $fechaString"
            }
        }

        binding.btnFinalizarRenta.setOnClickListener {
            if (fechaEntregaMs == 0L || fechaDevolucionMs == 0L) {
                Toast.makeText(requireContext(), "Selecciona ambas fechas", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (fechaDevolucionMs < fechaEntregaMs) {
                Toast.makeText(requireContext(), "Fecha de devolución inválida", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (binding.toggleMetodoPago.checkedButtonId == View.NO_ID) {
                Toast.makeText(requireContext(), "Selecciona un método de pago", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            binding.btnFinalizarRenta.isEnabled = false
            procesarRenta()
        }
    }

    private fun pedirPermisoNotificaciones() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    requireContext(), Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                notifPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }

    private fun mostrarDatePicker(onDateSelected: (Long, String) -> Unit) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(requireContext(), { _, y, m, d ->
            val sel = Calendar.getInstance()
            sel.set(y, m, d)
            val formatStr = "$d/${m + 1}/$y"
            onDateSelected(sel.timeInMillis, formatStr)
        }, year, month, day).apply {
            datePicker.minDate = System.currentTimeMillis() - 1000
        }.show()
    }

    private fun calcularTotal(): Double {
        return listaProductos.sumOf { (it.furniture.precio * it.cantidadSeleccionada) }
    }

    private fun procesarRenta() {
        val userId = auth.currentUser?.uid
        if (userId == null) {
            Toast.makeText(requireContext(), "Error de sesión", Toast.LENGTH_SHORT).show()
            binding.btnFinalizarRenta.isEnabled = true
            return
        }

        val metodoPago = when (binding.toggleMetodoPago.checkedButtonId) {
            R.id.btnPagoEfectivo -> "Efectivo"
            R.id.btnPagoTransferencia -> "Transferencia bancaria"
            else -> "No especificado"
        }

        val orderId = UUID.randomUUID().toString()
        val cartItems = listaProductos.map {
            CartItem(it.furniture.id, it.cantidadSeleccionada, it.furniture.precio)
        }

        val order = RentalOrder(
            id = orderId,
            userId = userId,
            items = cartItems,
            deliveryDate = fechaEntregaMs,
            returnDate = fechaDevolucionMs,
            status = OrderStatus.PENDING,
            paymentStatus = PaymentStatus.PENDING,
            totalCost = total,
            paymentMethod = metodoPago
        )

        // Transacción Firestore: PRIMERO todas las lecturas, LUEGO todas las escrituras
        db.runTransaction { transaction ->

            // ── FASE 1: TODAS las lecturas ──────────────────────────────────────────
            val snapshots = listaProductos.map { pro ->
                val docRef = db.collection("mobiliario").document(pro.furniture.id)
                Pair(pro, transaction.get(docRef))
            }

            // ── FASE 2: Validar stock ───────────────────────────────────────────────
            snapshots.forEach { (pro, snapshot) ->
                if (!snapshot.exists()) {
                    throw Exception("Producto no encontrado: ${pro.furniture.nombreProducto}")
                }
                val stockActual = snapshot.getLong("existencia") ?: 0
                if (stockActual < pro.cantidadSeleccionada) {
                    throw Exception("Sin stock para: ${pro.furniture.nombreProducto}")
                }
            }

            // ── FASE 3: TODAS las escrituras ───────────────────────────────────────
            snapshots.forEach { (pro, snapshot) ->
                val stockActual = snapshot.getLong("existencia") ?: 0
                val docRef = db.collection("mobiliario").document(pro.furniture.id)
                transaction.update(docRef, "existencia", stockActual - pro.cantidadSeleccionada)
            }

            // Guardar el pedido
            val orderRef = db.collection("rentas").document(orderId)
            transaction.set(orderRef, order)

            null
        }.addOnSuccessListener {
            // Notificación local al usuario
            NotificationHelper.mostrar(
                requireContext(),
                "✅ Renta Confirmada",
                "Tu pedido #${orderId.take(6).uppercase()} ha sido enviado. Total: \$${"%.2f".format(total)}"
            )

            // Escribir notificación en Firestore para el admin
            enviarNotificacionFirestore(
                paraRol = "ADMINISTRADOR",
                paraUserId = null,
                titulo = "🛋️ Nuevo Pedido",
                cuerpo = "Pedido #${orderId.take(6).uppercase()} — \$${"%.2f".format(total)} — Pago: $metodoPago"
            )

            // Buscar el número del admin y abrir WhatsApp
            db.collection("usuarios")
                .whereEqualTo("role", "ADMINISTRADOR")
                .limit(1)
                .get()
                .addOnSuccessListener { querySnapshot ->
                    // Guard: si el Fragment ya no está adjunto, no tocar la UI
                    if (!isAdded || context == null) return@addOnSuccessListener

                    val adminDoc = querySnapshot.documents.firstOrNull()
                    val telefonoAdmin = adminDoc?.getString("phone")

                    if (telefonoAdmin.isNullOrBlank()) {
                        Toast.makeText(
                            requireContext(),
                            "Renta confirmada. No se encontró número del administrador.",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        val numLimpio = telefonoAdmin.filter { it.isDigit() }
                        val numWA = if (numLimpio.length == 10) "52$numLimpio" else numLimpio
                        enviarMensajePrivadoWhatsApp(order, metodoPago, numWA)
                    }

                    (activity as? MainActivity)?.limpiarCarrito()
                    parentFragmentManager.popBackStack()
                }
                .addOnFailureListener {
                    if (!isAdded || context == null) return@addOnFailureListener
                    Toast.makeText(
                        requireContext(),
                        "Renta confirmada. No se pudo contactar al admin por WhatsApp.",
                        Toast.LENGTH_LONG
                    ).show()
                    (activity as? MainActivity)?.limpiarCarrito()
                    parentFragmentManager.popBackStack()
                }

        }.addOnFailureListener { e ->
            Toast.makeText(requireContext(), "Error en el pedido: ${e.message}", Toast.LENGTH_LONG).show()
            binding.btnFinalizarRenta.isEnabled = true
        }
    }

    /**
     * Escribe un documento en la colección "notificaciones" de Firestore.
     * El listener en MainActivity / AdminMainActivity lo leerá y mostrará la notif local.
     */
    private fun enviarNotificacionFirestore(
        paraRol: String?,
        paraUserId: String?,
        titulo: String,
        cuerpo: String
    ) {
        val notif = hashMapOf(
            "paraRol" to paraRol,
            "paraUserId" to paraUserId,
            "titulo" to titulo,
            "cuerpo" to cuerpo,
            "leido" to false,
            "timestamp" to System.currentTimeMillis()
        )
        db.collection("notificaciones").add(notif)
    }

    private fun enviarMensajePrivadoWhatsApp(order: RentalOrder, metodoPago: String, numeroAdmin: String) {
        val cEntrega = Calendar.getInstance().apply { timeInMillis = order.deliveryDate }
        val dE = "${cEntrega.get(Calendar.DAY_OF_MONTH)}/${cEntrega.get(Calendar.MONTH)+1}/${cEntrega.get(Calendar.YEAR)}"

        val cDev = Calendar.getInstance().apply { timeInMillis = order.returnDate }
        val dD = "${cDev.get(Calendar.DAY_OF_MONTH)}/${cDev.get(Calendar.MONTH)+1}/${cDev.get(Calendar.YEAR)}"

        var itemsTxt = ""
        listaProductos.forEach {
            itemsTxt += "  🔸 ${it.cantidadSeleccionada}x ${it.furniture.nombreProducto} — \$${it.furniture.precio} c/u\n"
        }

        val idCorto = order.id.take(8).uppercase()
        val iconoPago = if (metodoPago == "Efectivo") "💵" else "🏦"

        val mensaje = """
¡Hola! Nueva solicitud de renta desde la App 📱

*📋 ID Pedido:* $idCorto

*🪑 Artículos:*
$itemsTxt
*📅 Fechas:*
  Entrega: $dE
  Devolución: $dD

*💰 Total a Pagar:* $${"%.2f".format(order.totalCost)}
*$iconoPago Método de Pago:* $metodoPago

${if (metodoPago == "Transferencia bancaria") "Por favor indícame los datos de la cuenta para realizar el pago. ¡Gracias! 🙏" else "Pagaré en efectivo al momento de la entrega. ¡Gracias! 🙏"}
        """.trimIndent()

        val ctx = context ?: return  // Guard: si no hay contexto válido, salir sin crash

        // ── Intento 1: Abrir WhatsApp directamente (más confiable, sin selector de navegador) ──
        val intentDirecto = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://api.whatsapp.com/send?phone=$numeroAdmin&text=${Uri.encode(mensaje)}")
            setPackage("com.whatsapp")
        }

        // ── Intento 2: WhatsApp Business ──
        val intentBusiness = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://api.whatsapp.com/send?phone=$numeroAdmin&text=${Uri.encode(mensaje)}")
            setPackage("com.whatsapp.w4b")
        }

        // ── Intento 3: Fallback genérico (navegador o cualquier app que maneje la URL) ──
        val intentFallback = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://api.whatsapp.com/send?phone=$numeroAdmin&text=${Uri.encode(mensaje)}")
        }

        val pm = ctx.packageManager
        when {
            intentDirecto.resolveActivity(pm) != null -> {
                Toast.makeText(ctx, "Renta confirmada. Abriendo WhatsApp...", Toast.LENGTH_LONG).show()
                activity?.startActivity(intentDirecto)
            }
            intentBusiness.resolveActivity(pm) != null -> {
                Toast.makeText(ctx, "Renta confirmada. Abriendo WhatsApp Business...", Toast.LENGTH_LONG).show()
                activity?.startActivity(intentBusiness)
            }
            intentFallback.resolveActivity(pm) != null -> {
                Toast.makeText(ctx, "Renta confirmada. Redirigiendo a WhatsApp...", Toast.LENGTH_LONG).show()
                activity?.startActivity(intentFallback)
            }
            else -> {
                // ── Fallback final: Mostrar diálogo con número y mensaje para copiar ──
                mostrarDialogoContactoManual(ctx, numeroAdmin, mensaje)
            }
        }
    }

    /**
     * Fallback cuando WhatsApp no está disponible.
     * Muestra el número del admin y el mensaje formateado en un diálogo copiable.
     */
    private fun mostrarDialogoContactoManual(ctx: Context, numero: String, mensaje: String) {
        val clipboard = ctx.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        AlertDialog.Builder(ctx)
            .setTitle("📋 Renta Confirmada")
            .setMessage(
                "Tu renta fue registrada exitosamente.\n\n" +
                "WhatsApp no está disponible en este dispositivo.\n" +
                "Contacta al administrador manualmente:\n\n" +
                "📞 Número: $numero\n\n" +
                "Puedes copiar el mensaje del pedido con el botón de abajo."
            )
            .setPositiveButton("Copiar mensaje del pedido") { dialog, _ ->
                val clip = ClipData.newPlainText("Pedido Renta", mensaje)
                clipboard.setPrimaryClip(clip)
                Toast.makeText(ctx, "✅ Mensaje copiado al portapapeles", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton("Cerrar") { dialog, _ -> dialog.dismiss() }
            .setCancelable(false)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

```

---

<a id='javacomtuempresarentaappuiuserMainActivitykt'></a>
### Archivo: `java/com/tuempresa/rentaapp/ui/user/MainActivity.kt`

**Propósito general:** Aquí es donde vive casi todo lo que ve el cliente final. Contiene las pantallas principales (Fragments y Activities) para navegar por el catálogo, ver los detalles, armar el carrito de rentas y ver el historial de pedidos personales.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```kotlin
package com.tuempresa.rentaapp.ui.user

import com.tuempresa.rentaapp.R
import com.tuempresa.rentaapp.models.Producto
import com.tuempresa.rentaapp.ui.common.PerfilFragment
import com.tuempresa.rentaapp.utils.NotificationHelper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration

class MainActivity : AppCompatActivity() {

    var totalGeneral: Double = 0.0

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private var notifListener: ListenerRegistration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NotificationHelper.createChannel(this)

        // Cargar fragment inicial
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedor_fragmentos, CatalogoFragment())
                .commit()
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.nav_catalogo -> CatalogoFragment()
                R.id.nav_rentas -> RentasFragment()
                R.id.nav_perfil -> PerfilFragment()
                else -> null
            }
            fragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.contenedor_fragmentos, it)
                    .commit()
            }
            true
        }

        // Escuchar notificaciones de Firestore dirigidas a este usuario
        escucharNotificaciones()
    }

    private fun escucharNotificaciones() {
        val userId = auth.currentUser?.uid ?: return

        notifListener = db.collection("notificaciones")
            .whereEqualTo("paraUserId", userId)
            .whereEqualTo("leido", false)
            .addSnapshotListener { snapshot, e ->
                if (e != null || snapshot == null) return@addSnapshotListener
                for (doc in snapshot.documents) {
                    val titulo = doc.getString("titulo") ?: "Notificación"
                    val cuerpo = doc.getString("cuerpo") ?: ""
                    NotificationHelper.mostrar(this, titulo, cuerpo)
                    // Marcar como leído para no volver a mostrarlo
                    doc.reference.update("leido", true)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        notifListener?.remove()
    }

    fun irConfirmacion(productosSeleccionados: List<Producto>) {
        val fragment = ConfirmacionFragment()
        val bundle = Bundle()
        bundle.putSerializable("productos", ArrayList(productosSeleccionados))
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedor_fragmentos, fragment)
            .addToBackStack(null)
            .commit()
    }

    fun actualizarTotal(lista: List<Producto>) {
        totalGeneral = lista.sumOf { it.furniture.precio * it.cantidadSeleccionada }
    }

    fun limpiarCarrito() {
        totalGeneral = 0.0
    }
}

```

---

<a id='javacomtuempresarentaappuiuserRentasFragmentkt'></a>
### Archivo: `java/com/tuempresa/rentaapp/ui/user/RentasFragment.kt`

**Propósito general:** Aquí es donde vive casi todo lo que ve el cliente final. Contiene las pantallas principales (Fragments y Activities) para navegar por el catálogo, ver los detalles, armar el carrito de rentas y ver el historial de pedidos personales.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```kotlin
package com.tuempresa.rentaapp.ui.user

import com.tuempresa.rentaapp.adapters.PedidoAdapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuempresa.rentaapp.databinding.FragmentRentasBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.tuempresa.rentaapp.models.RentalOrder

class RentasFragment : Fragment() {

    private var _binding: FragmentRentasBinding? = null
    private val binding get() = _binding!!

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    private lateinit var adapter: PedidoAdapter
    private var listaPedidos = mutableListOf<RentalOrder>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRentasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PedidoAdapter(listaPedidos, esAdmin = false)

        binding.rvMisRentas.layoutManager = LinearLayoutManager(context)
        binding.rvMisRentas.adapter = adapter

        cargarMisPedidos()
    }

    private fun cargarMisPedidos() {
        val uid = auth.currentUser?.uid ?: return

        db.collection("rentas")
            .whereEqualTo("userId", uid)
            // Firebase requiere índice compuesto para where + orderBy. Lo evitamos ordenando localmente por ahora.
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Toast.makeText(context, "Error cargando tus rentas", Toast.LENGTH_SHORT).show()
                    return@addSnapshotListener
                }

                if (snapshot != null) {
                    listaPedidos.clear()
                    for (doc in snapshot.documents) {
                        val pedido = doc.toObject(RentalOrder::class.java)
                        if (pedido != null) {
                            listaPedidos.add(pedido)
                        }
                    }
                    // Ordenamos localmente del más reciente
                    listaPedidos.sortByDescending { it.deliveryDate }
                    adapter.actualizarLista(listaPedidos)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

```

---

<a id='javacomtuempresarentaapputilsNotificationHelperkt'></a>
### Archivo: `java/com/tuempresa/rentaapp/utils/NotificationHelper.kt`

**Propósito general:** Archivos y ayudantes (helpers) de utilidad general. Por ejemplo, cosas que se usan en varias partes de la app, como el sistema para mostrar notificaciones locales en el teléfono.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```kotlin
package com.tuempresa.rentaapp.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.tuempresa.rentaapp.R

object NotificationHelper {

    private const val CHANNEL_ID = "rentaapp_channel"
    private const val CHANNEL_NAME = "RentaApp Notificaciones"
    private var notifId = 1000

    fun createChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Notificaciones de pedidos y rentas"
            }
            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

    fun mostrar(context: Context, titulo: String, cuerpo: String) {
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(titulo)
            .setContentText(cuerpo)
            .setStyle(NotificationCompat.BigTextStyle().bigText(cuerpo))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .build()
        manager.notify(notifId++, notification)
    }
}

```

---

<a id='resdrawableic_launcher_backgroundxml'></a>
### Archivo: `res/drawable/ic_launcher_background.xml`

**Propósito general:** Este es uno de los archivos de configuración o recursos base que necesita Android Studio para compilar el proyecto correctamente.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="108dp"
    android:height="108dp"
    android:viewportWidth="108"
    android:viewportHeight="108">
    <path
        android:fillColor="#3DDC84"
        android:pathData="M0,0h108v108h-108z" />
    <path
        android:fillColor="#00000000"
        android:pathData="M9,0L9,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M19,0L19,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M29,0L29,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M39,0L39,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M49,0L49,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M59,0L59,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M69,0L69,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M79,0L79,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M89,0L89,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M99,0L99,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,9L108,9"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,19L108,19"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,29L108,29"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,39L108,39"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,49L108,49"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,59L108,59"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,69L108,69"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,79L108,79"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,89L108,89"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,99L108,99"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M19,29L89,29"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M19,39L89,39"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M19,49L89,49"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M19,59L89,59"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M19,69L89,69"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M19,79L89,79"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M29,19L29,89"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M39,19L39,89"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M49,19L49,89"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M59,19L59,89"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M69,19L69,89"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M79,19L79,89"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
</vector>

```

---

<a id='resdrawableic_launcher_foregroundxml'></a>
### Archivo: `res/drawable/ic_launcher_foreground.xml`

**Propósito general:** Este es uno de los archivos de configuración o recursos base que necesita Android Studio para compilar el proyecto correctamente.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:aapt="http://schemas.android.com/aapt"
    android:width="108dp"
    android:height="108dp"
    android:viewportWidth="108"
    android:viewportHeight="108">
    <path android:pathData="M31,63.928c0,0 6.4,-11 12.1,-13.1c7.2,-2.6 26,-1.4 26,-1.4l38.1,38.1L107,108.928l-32,-1L31,63.928z">
        <aapt:attr name="android:fillColor">
            <gradient
                android:endX="85.84757"
                android:endY="92.4963"
                android:startX="42.9492"
                android:startY="49.59793"
                android:type="linear">
                <item
                    android:color="#44000000"
                    android:offset="0.0" />
                <item
                    android:color="#00000000"
                    android:offset="1.0" />
            </gradient>
        </aapt:attr>
    </path>
    <path
        android:fillColor="#FFFFFF"
        android:fillType="nonZero"
        android:pathData="M65.3,45.828l3.8,-6.6c0.2,-0.4 0.1,-0.9 -0.3,-1.1c-0.4,-0.2 -0.9,-0.1 -1.1,0.3l-3.9,6.7c-6.3,-2.8 -13.4,-2.8 -19.7,0l-3.9,-6.7c-0.2,-0.4 -0.7,-0.5 -1.1,-0.3C38.8,38.328 38.7,38.828 38.9,39.228l3.8,6.6C36.2,49.428 31.7,56.028 31,63.928h46C76.3,56.028 71.8,49.428 65.3,45.828zM43.4,57.328c-0.8,0 -1.5,-0.5 -1.8,-1.2c-0.3,-0.7 -0.1,-1.5 0.4,-2.1c0.5,-0.5 1.4,-0.7 2.1,-0.4c0.7,0.3 1.2,1 1.2,1.8C45.3,56.528 44.5,57.328 43.4,57.328L43.4,57.328zM64.6,57.328c-0.8,0 -1.5,-0.5 -1.8,-1.2s-0.1,-1.5 0.4,-2.1c0.5,-0.5 1.4,-0.7 2.1,-0.4c0.7,0.3 1.2,1 1.2,1.8C66.5,56.528 65.6,57.328 64.6,57.328L64.6,57.328z"
        android:strokeWidth="1"
        android:strokeColor="#00000000" />
</vector>
```

---

<a id='reslayoutactivity_admin_mainxml'></a>
### Archivo: `res/layout/activity_admin_main.xml`

**Propósito general:** Esta carpeta contiene todos los archivos XML de diseño. Son el esqueleto visual de cada pantalla, diálogo y celda de las listas, donde se acomodan los textos, botones, imágenes y listas.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <FrameLayout
        android:id="@+id/contenedor_fragmentos"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_above="@id/bottom_navigation" />

    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottom_navigation"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:background="#FFFFFF"
        app:menu="@menu/menu_navegacion_admin"
        app:itemIconTint="#002366"
        app:itemTextColor="#002366" />

</RelativeLayout>

```

---

<a id='reslayoutactivity_loginxml'></a>
### Archivo: `res/layout/activity_login.xml`

**Propósito general:** Esta carpeta contiene todos los archivos XML de diseño. Son el esqueleto visual de cada pantalla, diálogo y celda de las listas, donde se acomodan los textos, botones, imágenes y listas.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="24dp">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Renta Mobiliario"
        android:textSize="28sp"
        android:textStyle="bold"
        android:layout_marginBottom="40dp"/>

    <EditText
        android:id="@+id/etEmail"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Correo Electrónico"
        android:inputType="textEmailAddress" />

    <EditText
        android:id="@+id/etPassword"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Contraseña"
        android:inputType="textPassword"
        android:layout_marginTop="16dp" />

    <Button
        android:id="@+id/btnContinuar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Iniciar Sesión"
        android:layout_marginTop="24dp" />

    <TextView
        android:id="@+id/tvIrAlRegistro"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="¿No tienes cuenta? Regístrate aquí"
        android:layout_marginTop="20dp"
        android:textColor="#002366"
        android:textStyle="bold"/>

</LinearLayout>
```

---

<a id='reslayoutactivity_mainxml'></a>
### Archivo: `res/layout/activity_main.xml`

**Propósito general:** Esta carpeta contiene todos los archivos XML de diseño. Son el esqueleto visual de cada pantalla, diálogo y celda de las listas, donde se acomodan los textos, botones, imágenes y listas.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <FrameLayout
        android:id="@+id/contenedor_fragmentos"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_above="@id/bottom_navigation" />

    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottom_navigation"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:background="@android:color/white"
        app:menu="@menu/menu_navegacion"
        app:itemIconTint="@android:color/black"
        app:itemTextColor="@android:color/black" />

</RelativeLayout>
```

---

<a id='reslayoutactivity_registroxml'></a>
### Archivo: `res/layout/activity_registro.xml`

**Propósito general:** Esta carpeta contiene todos los archivos XML de diseño. Son el esqueleto visual de cada pantalla, diálogo y celda de las listas, donde se acomodan los textos, botones, imágenes y listas.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="24dp"
    android:gravity="center"
    android:background="#F5F5F5">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Bienvenido"
        android:textSize="32sp"
        android:textStyle="bold"
        android:textColor="#002366"
        android:layout_marginBottom="8dp"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Regístrate para rentar tu mobiliario"
        android:textSize="16sp"
        android:textColor="#666666"
        android:layout_marginBottom="32dp"/>

    <EditText
        android:id="@+id/etNombre"
        android:layout_width="match_parent"
        android:layout_height="55dp"
        android:hint="Nombre Completo"
        android:background="@android:drawable/editbox_background"
        android:paddingLeft="15dp"
        android:inputType="textPersonName"
        android:layout_marginBottom="12dp"/>

    <EditText
        android:id="@+id/etEmail"
        android:layout_width="match_parent"
        android:layout_height="55dp"
        android:hint="Correo Electrónico"
        android:background="@android:drawable/editbox_background"
        android:paddingLeft="15dp"
        android:inputType="textEmailAddress"
        android:layout_marginBottom="12dp"/>

    <EditText
        android:id="@+id/etPassword"
        android:layout_width="match_parent"
        android:layout_height="55dp"
        android:hint="Contraseña"
        android:background="@android:drawable/editbox_background"
        android:paddingLeft="15dp"
        android:inputType="textPassword"
        android:layout_marginBottom="12dp"/>

    <EditText
        android:id="@+id/etTelefono"
        android:layout_width="match_parent"
        android:layout_height="55dp"
        android:hint="Teléfono (10 dígitos)"
        android:background="@android:drawable/editbox_background"
        android:paddingLeft="15dp"
        android:inputType="phone"
        android:layout_marginBottom="24dp"/>

    <com.google.android.material.switchmaterial.SwitchMaterial
        android:id="@+id/switchAdminRole"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="20dp"
        android:text="Registrar como Administrador"
        android:textColor="#002366"
        android:textSize="14sp"
        app:thumbTint="#002366"
        app:trackTint="#A0B2D8"
        xmlns:app="http://schemas.android.com/apk/res-auto"/>

    <Button
        android:id="@+id/btnRegistrar"
        android:layout_width="match_parent"
        android:layout_height="55dp"
        android:text="CREAR CUENTA"
        android:backgroundTint="#002366"
        android:textColor="#FFFFFF"
        android:textStyle="bold"/>

    <TextView
        android:id="@+id/tvIrAlLogin"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="¿Ya tienes cuenta? Inicia Sesión"
        android:layout_marginTop="20dp"
        android:textColor="#002366"
        android:textStyle="bold"/>
</LinearLayout>
```

---

<a id='reslayoutdialog_admin_productoxml'></a>
### Archivo: `res/layout/dialog_admin_producto.xml`

**Propósito general:** Esta carpeta contiene todos los archivos XML de diseño. Son el esqueleto visual de cada pantalla, diálogo y celda de las listas, donde se acomodan los textos, botones, imágenes y listas.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="24dp">

    <TextView
        android:id="@+id/tvDialogTitulo"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Agregar Producto"
        android:textSize="20sp"
        android:textStyle="bold"
        android:textColor="#002366"
        android:layout_marginBottom="16dp"/>

    <EditText
        android:id="@+id/etDialogNombre"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Nombre del Mobiliario"
        android:inputType="textCapSentences"
        android:layout_marginBottom="12dp"/>

    <EditText
        android:id="@+id/etDialogDesc"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Descripción"
        android:inputType="textMultiLine"
        android:lines="3"
        android:gravity="top|start"
        android:layout_marginBottom="12dp"/>

    <EditText
        android:id="@+id/etDialogPrecio"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Precio de Renta ($)"
        android:inputType="numberDecimal"
        android:layout_marginBottom="12dp"/>

    <EditText
        android:id="@+id/etDialogStock"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Existencias Totales"
        android:inputType="number"
        android:layout_marginBottom="24dp"/>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:gravity="end">

        <Button
            android:id="@+id/btnDialogCancelar"
            style="@style/Widget.MaterialComponents.Button.TextButton"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Cancelar"
            android:textColor="#666666" />

        <Button
            android:id="@+id/btnDialogGuardar"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Guardar"
            android:backgroundTint="#002366"
            android:textColor="#FFFFFF" />
    </LinearLayout>

</LinearLayout>

```

---

<a id='reslayoutfragment_admin_inventarioxml'></a>
### Archivo: `res/layout/fragment_admin_inventario.xml`

**Propósito general:** Esta carpeta contiene todos los archivos XML de diseño. Son el esqueleto visual de cada pantalla, diálogo y celda de las listas, donde se acomodan los textos, botones, imágenes y listas.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.coordinatorlayout.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#F8F9FA">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:padding="16dp"
            android:text="Gestión de Inventario"
            android:textSize="22sp"
            android:textStyle="bold"
            android:textColor="#002366"
            android:background="@android:color/white"
            android:elevation="4dp"/>

        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/rvAdminProductos"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:padding="8dp"
            android:clipToPadding="false"/>
            
    </LinearLayout>

    <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/fabAgregarProducto"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|end"
        android:layout_margin="24dp"
        android:src="@android:drawable/ic_input_add"
        app:backgroundTint="#002366"
        app:tint="@android:color/white" />

</androidx.coordinatorlayout.widget.CoordinatorLayout>

```

---

<a id='reslayoutfragment_admin_pedidosxml'></a>
### Archivo: `res/layout/fragment_admin_pedidos.xml`

**Propósito general:** Esta carpeta contiene todos los archivos XML de diseño. Son el esqueleto visual de cada pantalla, diálogo y celda de las listas, donde se acomodan los textos, botones, imágenes y listas.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="#F8F9FA">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="16dp"
        android:text="Gestión de Pedidos"
        android:textSize="22sp"
        android:textStyle="bold"
        android:textColor="#002366"
        android:background="@android:color/white"
        android:elevation="4dp"/>

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rvAdminPedidos"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:padding="8dp"
        android:clipToPadding="false"/>

</LinearLayout>

```

---

<a id='reslayoutfragment_catalogoxml'></a>
### Archivo: `res/layout/fragment_catalogo.xml`

**Propósito general:** Esta carpeta contiene todos los archivos XML de diseño. Son el esqueleto visual de cada pantalla, diálogo y celda de las listas, donde se acomodan los textos, botones, imágenes y listas.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rvProductos"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1" />

    <Button
        android:id="@+id/btnConfirmarRenta"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Confirmar renta"
        android:layout_margin="16dp" />

</LinearLayout>
```

---

<a id='reslayoutfragment_confirmacionxml'></a>
### Archivo: `res/layout/fragment_confirmacion.xml`

**Propósito general:** Esta carpeta contiene todos los archivos XML de diseño. Son el esqueleto visual de cada pantalla, diálogo y celda de las listas, donde se acomodan los textos, botones, imágenes y listas.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#F8F9FA">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="24dp">

        <!-- Título -->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Resumen de Renta"
            android:textSize="22sp"
            android:textStyle="bold"
            android:textColor="#002366"
            android:layout_marginBottom="16dp"
            android:gravity="center"/>

        <!-- Fechas -->
        <TextView
            android:id="@+id/tvFechasError"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="📅 Selecciona tus fechas de renta:"
            android:textColor="#444444"
            android:textSize="14sp"
            android:layout_marginBottom="8dp"/>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:layout_marginBottom="16dp">

            <Button
                android:id="@+id/btnFechaEntrega"
                style="@style/Widget.MaterialComponents.Button.OutlinedButton"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="Entrega"
                android:layout_marginEnd="8dp" />

            <Button
                android:id="@+id/btnFechaDevolucion"
                style="@style/Widget.MaterialComponents.Button.OutlinedButton"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="Devolución"
                android:layout_marginStart="8dp"/>
        </LinearLayout>

        <View
            android:layout_width="match_parent"
            android:layout_height="1dp"
            android:background="#E0E0E0"
            android:layout_marginBottom="16dp"/>

        <!-- Artículos -->
        <TextView
            android:id="@+id/tvResumenArticulos"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Artículos:"
            android:textSize="16sp"
            android:minLines="2"/>

        <View
            android:layout_width="match_parent"
            android:layout_height="1dp"
            android:background="#E0E0E0"
            android:layout_marginTop="16dp"
            android:layout_marginBottom="16dp"/>

        <!-- Total -->
        <TextView
            android:id="@+id/tvTotalConfirmacion"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Total: $0.00"
            android:textSize="24sp"
            android:textStyle="bold"
            android:textColor="#002366"
            android:layout_gravity="end"
            android:layout_marginBottom="20dp"/>

        <!-- SECCIÓN MÉTODO DE PAGO -->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="💳 Método de Pago"
            android:textSize="16sp"
            android:textStyle="bold"
            android:textColor="#002366"
            android:layout_marginBottom="10dp"/>

        <com.google.android.material.button.MaterialButtonToggleGroup
            android:id="@+id/toggleMetodoPago"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="24dp"
            app:singleSelection="true"
            app:selectionRequired="true">

            <com.google.android.material.button.MaterialButton
                android:id="@+id/btnPagoEfectivo"
                style="@style/Widget.MaterialComponents.Button.OutlinedButton"
                android:layout_width="0dp"
                android:layout_height="48dp"
                android:layout_weight="1"
                android:text="💵 Efectivo"
                android:textSize="13sp"/>

            <com.google.android.material.button.MaterialButton
                android:id="@+id/btnPagoTransferencia"
                style="@style/Widget.MaterialComponents.Button.OutlinedButton"
                android:layout_width="0dp"
                android:layout_height="48dp"
                android:layout_weight="1"
                android:text="🏦 Transferencia"
                android:textSize="13sp"/>

        </com.google.android.material.button.MaterialButtonToggleGroup>

        <!-- Botón WhatsApp -->
        <com.google.android.material.button.MaterialButton
            android:id="@+id/btnFinalizarRenta"
            android:layout_width="match_parent"
            android:layout_height="56dp"
            android:text="✅  CONFIRMAR Y ENVIAR A WHATSAPP"
            android:textColor="@android:color/white"
            android:textStyle="bold"
            android:textSize="13sp"
            app:backgroundTint="#25D366"
            app:cornerRadius="12dp"/>

    </LinearLayout>
</ScrollView>
```

---

<a id='reslayoutfragment_perfilxml'></a>
### Archivo: `res/layout/fragment_perfil.xml`

**Propósito general:** Esta carpeta contiene todos los archivos XML de diseño. Son el esqueleto visual de cada pantalla, diálogo y celda de las listas, donde se acomodan los textos, botones, imágenes y listas.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="24dp"
    android:gravity="center_horizontal"
    android:background="#F8F9FA">

    <ImageView
        android:id="@+id/ivFotoPerfil"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:src="@android:drawable/ic_menu_gallery"
        android:layout_marginTop="20dp"
        android:layout_marginBottom="20dp"
        app:tint="#002366" /> 

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Mi Perfil"
        android:textSize="20sp"
        android:textStyle="bold"
        android:textColor="#333333"
        android:layout_marginBottom="16dp"
        android:gravity="center"/>

    <com.google.android.material.textfield.TextInputLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="12dp">
        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/etNombrePerfil"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Nombre Completo"
            android:inputType="textPersonName" />
    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="12dp">
        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/etTelefonoPerfil"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Teléfono"
            android:inputType="phone" />
    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="16dp">
        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/etEmailPerfil"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Correo Electrónico"
            android:enabled="false"
            android:inputType="textEmailAddress" />
    </com.google.android.material.textfield.TextInputLayout>

    <Button
        android:id="@+id/btnGuardarPerfil"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="GUARDAR CAMBIOS"
        android:backgroundTint="#002366"
        android:textColor="#FFFFFF" />

    <Button
        android:id="@+id/btnCerrarSesion"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="CERRAR SESIÓN"
        android:backgroundTint="#FF4444"
        android:textColor="#FFFFFF"
        android:layout_marginTop="24dp"/> 

</LinearLayout>
```

---

<a id='reslayoutfragment_rentasxml'></a>
### Archivo: `res/layout/fragment_rentas.xml`

**Propósito general:** Esta carpeta contiene todos los archivos XML de diseño. Son el esqueleto visual de cada pantalla, diálogo y celda de las listas, donde se acomodan los textos, botones, imágenes y listas.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="#F8F9FA">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="16dp"
        android:text="Mis Rentas"
        android:textSize="22sp"
        android:textStyle="bold"
        android:textColor="#002366"
        android:background="@android:color/white"
        android:elevation="4dp"/>

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rvMisRentas"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:padding="8dp"
        android:clipToPadding="false"/>

</LinearLayout>
```

---

<a id='reslayoutitem_admin_productoxml'></a>
### Archivo: `res/layout/item_admin_producto.xml`

**Propósito general:** Esta carpeta contiene todos los archivos XML de diseño. Son el esqueleto visual de cada pantalla, diálogo y celda de las listas, donde se acomodan los textos, botones, imágenes y listas.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.cardview.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="8dp"
    app:cardCornerRadius="8dp"
    app:cardElevation="4dp">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="16dp">

        <TextView
            android:id="@+id/tvAdminNombreProd"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Nombre del Producto"
            android:textColor="#000000"
            android:textSize="18sp"
            android:textStyle="bold" />

        <TextView
            android:id="@+id/tvAdminDescProd"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Descripción..."
            android:textColor="#666666" 
            android:layout_marginTop="4dp"/>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:layout_marginTop="8dp">

            <TextView
                android:id="@+id/tvAdminPrecioProd"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="$0.00"
                android:textColor="#002366"
                android:textSize="18sp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/tvAdminStockProd"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Stock: 0"
                android:textColor="#000000"
                android:textStyle="bold" />
        </LinearLayout>
        
        <View
            android:layout_width="match_parent"
            android:layout_height="1dp"
            android:background="#E0E0E0"
            android:layout_marginTop="12dp"
            android:layout_marginBottom="8dp"/>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:gravity="end">

            <Button
                android:id="@+id/btnAdminEditar"
                style="@style/Widget.MaterialComponents.Button.TextButton"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Editar"
                android:textColor="#0066CC" />

            <Button
                android:id="@+id/btnAdminEliminar"
                style="@style/Widget.MaterialComponents.Button.TextButton"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Eliminar"
                android:textColor="#CC0000" />
        </LinearLayout>
    </LinearLayout>
</androidx.cardview.widget.CardView>

```

---

<a id='reslayoutitem_pedidoxml'></a>
### Archivo: `res/layout/item_pedido.xml`

**Propósito general:** Esta carpeta contiene todos los archivos XML de diseño. Son el esqueleto visual de cada pantalla, diálogo y celda de las listas, donde se acomodan los textos, botones, imágenes y listas.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.cardview.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="8dp"
    app:cardCornerRadius="8dp"
    app:cardElevation="4dp">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="16dp">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

            <TextView
                android:id="@+id/tvPedidoId"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="Pedido #12345"
                android:textColor="#002366"
                android:textSize="18sp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/tvPedidoEstado"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:background="#E8F5E9"
                android:paddingHorizontal="8dp"
                android:paddingVertical="4dp"
                android:text="PENDIENTE"
                android:textColor="#2E7D32"
                android:textStyle="bold" />
        </LinearLayout>

        <TextView
            android:id="@+id/tvPedidoFechas"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="4dp"
            android:text="Fechas..."
            android:textColor="#666666" />

        <TextView
            android:id="@+id/tvPedidoTotal"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="8dp"
            android:text="Total: $0.00"
            android:textSize="16sp"
            android:textStyle="bold" />

        <TextView
            android:id="@+id/tvPedidoItems"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="8dp"
            android:text="Articulos:\n- Silla"
            android:textColor="#666666"
            android:visibility="gone" />

        <View
            android:id="@+id/viewSeparador"
            android:layout_width="match_parent"
            android:layout_height="1dp"
            android:layout_marginTop="12dp"
            android:layout_marginBottom="8dp"
            android:background="#E0E0E0"
            android:visibility="gone"/>

        <!-- Este contenedor solo será visible para el Administrador -->
        <LinearLayout
            android:id="@+id/llAdminControles"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:gravity="end"
            android:orientation="horizontal"
            android:visibility="gone">

            <Button
                android:id="@+id/btnMarcarDevuelto"
                style="@style/Widget.MaterialComponents.Button.TextButton"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Marcar Devuelto"
                android:textColor="#0066CC" />

            <Button
                android:id="@+id/btnMarcarCancelado"
                style="@style/Widget.MaterialComponents.Button.TextButton"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Cancelar"
                android:textColor="#CC0000" />
        </LinearLayout>

    </LinearLayout>
</androidx.cardview.widget.CardView>

```

---

<a id='reslayoutitem_productoxml'></a>
### Archivo: `res/layout/item_producto.xml`

**Propósito general:** Esta carpeta contiene todos los archivos XML de diseño. Son el esqueleto visual de cada pantalla, diálogo y celda de las listas, donde se acomodan los textos, botones, imágenes y listas.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.cardview.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="8dp"
    app:cardCornerRadius="16dp"
    app:cardElevation="6dp"
    app:cardBackgroundColor="#9BA8C7">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="16dp">

        <TextView
            android:id="@+id/tvNombre"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Nombre del Producto"
            android:textColor="#0D0D0D"
            android:textSize="17sp"
            android:textStyle="bold"
            android:gravity="center_horizontal"/>

        <TextView
            android:id="@+id/tvDescripcion"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Descripción"
            android:textColor="#333333"
            android:textSize="13sp"
            android:gravity="center_horizontal"
            android:layout_marginTop="4dp"/>

        <TextView
            android:id="@+id/tvPrecio"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:text="$0.00"
            android:textColor="#003CFF"
            android:textSize="22sp"
            android:textStyle="bold"
            android:gravity="center_horizontal"/>

        <TextView
            android:id="@+id/tvStockDisponible"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Disponibles: 0"
            android:textSize="12sp"
            android:textColor="#4CAF50"
            android:gravity="center_horizontal"
            android:layout_marginTop="2dp"/>

        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="14dp"
            android:gravity="center_vertical"
            android:orientation="horizontal">

            <com.google.android.material.button.MaterialButton
                android:id="@+id/btnMenos"
                style="@style/Widget.MaterialComponents.Button"
                android:layout_width="44dp"
                android:layout_height="44dp"
                android:text="-"
                android:textSize="22sp"
                android:textColor="#FFFFFF"
                android:insetTop="0dp"
                android:insetBottom="0dp"
                android:padding="0dp"
                app:backgroundTint="#1A1A1A"
                app:cornerRadius="22dp"/>

            <TextView
                android:id="@+id/tvCantidad"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:padding="14dp"
                android:text="0"
                android:textSize="18sp"
                android:textColor="#0D0D0D"
                android:textStyle="bold"/>

            <com.google.android.material.button.MaterialButton
                android:id="@+id/btnMas"
                style="@style/Widget.MaterialComponents.Button"
                android:layout_width="44dp"
                android:layout_height="44dp"
                android:text="+"
                android:textSize="22sp"
                android:textColor="#FFFFFF"
                android:insetTop="0dp"
                android:insetBottom="0dp"
                android:padding="0dp"
                app:backgroundTint="#003CFF"
                app:cornerRadius="22dp"/>

        </LinearLayout>
    </LinearLayout>

</androidx.cardview.widget.CardView>
```

---

<a id='resmenumenu_navegacionxml'></a>
### Archivo: `res/menu/menu_navegacion.xml`

**Propósito general:** Este es uno de los archivos de configuración o recursos base que necesita Android Studio para compilar el proyecto correctamente.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/nav_catalogo"
        android:icon="@android:drawable/ic_menu_search"
        android:title="Catálogo" />
    <item
        android:id="@+id/nav_rentas"
        android:icon="@android:drawable/ic_menu_today"
        android:title="Mis Rentas" />
    <item
        android:id="@+id/nav_perfil"
        android:icon="@android:drawable/ic_menu_mylocation"
        android:title="Perfil" />
</menu>
```

---

<a id='resmenumenu_navegacion_adminxml'></a>
### Archivo: `res/menu/menu_navegacion_admin.xml`

**Propósito general:** Este es uno de los archivos de configuración o recursos base que necesita Android Studio para compilar el proyecto correctamente.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/nav_admin_inventario"
        android:icon="@android:drawable/ic_menu_agenda"
        android:title="Inventario" />
    <item
        android:id="@+id/nav_admin_pedidos"
        android:icon="@android:drawable/ic_menu_sort_by_size"
        android:title="Pedidos" />
    <item
        android:id="@+id/nav_perfil"
        android:icon="@android:drawable/ic_menu_mylocation"
        android:title="Perfil" />
</menu>

```

---

<a id='resmipmap-anydpi-v26ic_launcherxml'></a>
### Archivo: `res/mipmap-anydpi-v26/ic_launcher.xml`

**Propósito general:** Este es uno de los archivos de configuración o recursos base que necesita Android Studio para compilar el proyecto correctamente.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
    <background android:drawable="@drawable/ic_launcher_background" />
    <foreground android:drawable="@drawable/ic_launcher_foreground" />
    <monochrome android:drawable="@drawable/ic_launcher_foreground" />
</adaptive-icon>
```

---

<a id='resmipmap-anydpi-v26ic_launcher_roundxml'></a>
### Archivo: `res/mipmap-anydpi-v26/ic_launcher_round.xml`

**Propósito general:** Este es uno de los archivos de configuración o recursos base que necesita Android Studio para compilar el proyecto correctamente.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
    <background android:drawable="@drawable/ic_launcher_background" />
    <foreground android:drawable="@drawable/ic_launcher_foreground" />
    <monochrome android:drawable="@drawable/ic_launcher_foreground" />
</adaptive-icon>
```

---

<a id='resvalues-nightthemesxml'></a>
### Archivo: `res/values-night/themes.xml`

**Propósito general:** Este es uno de los archivos de configuración o recursos base que necesita Android Studio para compilar el proyecto correctamente.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Base.Theme.RentaMobiliarioApp" parent="Theme.Material3.DayNight.NoActionBar">
        <!-- Customize your dark theme here. -->
        <!-- <item name="colorPrimary">@color/my_dark_primary</item> -->
    </style>
</resources>
```

---

<a id='resvaluescolorsxml'></a>
### Archivo: `res/values/colors.xml`

**Propósito general:** Este es uno de los archivos de configuración o recursos base que necesita Android Studio para compilar el proyecto correctamente.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
<color name="azul_fuerte">#002366</color>
<color name="negro">#000000</color>
<color name="blanco">#FFFFFF</color>
<color name="gris_claro">#F5F5F5</color>
<color name="gris_texto">#555555</color>
</resources>
```

---

<a id='resvaluesstringsxml'></a>
### Archivo: `res/values/strings.xml`

**Propósito general:** Este es uno de los archivos de configuración o recursos base que necesita Android Studio para compilar el proyecto correctamente.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<resources>
    <string name="app_name">Renta Mobiliario App</string>
    <!-- TODO: Remove or change this placeholder text -->
    <string name="hello_blank_fragment">Hello blank fragment</string>
</resources>
```

---

<a id='resvaluesthemesxml'></a>
### Archivo: `res/values/themes.xml`

**Propósito general:** Este es uno de los archivos de configuración o recursos base que necesita Android Studio para compilar el proyecto correctamente.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Base.Theme.RentaMobiliarioApp" parent="Theme.Material3.DayNight.NoActionBar">
        <!-- Customize your light theme here. -->
        <!-- <item name="colorPrimary">@color/my_light_primary</item> -->
    </style>

    <style name="Theme.RentaMobiliarioApp" parent="Base.Theme.RentaMobiliarioApp" />
</resources>
```

---

<a id='resxmlbackup_rulesxml'></a>
### Archivo: `res/xml/backup_rules.xml`

**Propósito general:** Este es uno de los archivos de configuración o recursos base que necesita Android Studio para compilar el proyecto correctamente.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?><!--
   Sample backup rules file; uncomment and customize as necessary.
   See https://developer.android.com/guide/topics/data/autobackup
   for details.
   Note: This file is ignored for devices older than API 31
   See https://developer.android.com/about/versions/12/backup-restore
-->
<full-backup-content>
    <!--
   <include domain="sharedpref" path="."/>
   <exclude domain="sharedpref" path="device.xml"/>
-->
</full-backup-content>
```

---

<a id='resxmldata_extraction_rulesxml'></a>
### Archivo: `res/xml/data_extraction_rules.xml`

**Propósito general:** Este es uno de los archivos de configuración o recursos base que necesita Android Studio para compilar el proyecto correctamente.

#### Detalles del código

En este archivo podemos observar cómo se estructura la funcionalidad que necesita esta vista o modelo de datos. El código fue escrito de manera que fuera fácil de leer, mantener y escalar si la app sigue creciendo.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

Separar la lógica en diferentes archivos nos ayuda a que, si hay un error, sepamos exactamente a dónde ir sin tener un solo archivo gigante y confuso.

La comunicación con la base de datos o la interfaz se hace buscando que la app sea rápida y no se quede pegada mientras carga.

También se tomaron en cuenta las consideraciones de Android más recientes para que evitar inconsistencias al momento de correr en versiones viejas o nuevas del sistema.

Al conectar las variables o las vistas, se busca mantener el código organizado, declarando las cosas al principio y usándolas más abajo en el flujo normal.

El orden de las llamadas (callbacks) y cómo fluye la información permite que la experiencia sea muy fluida para el usuario final.

Cuando revisas este código, es clave entender que cada método o función tiene una tarea en específico asignada.

#### Código fuente completo:

```xml
<?xml version="1.0" encoding="utf-8"?><!--
   Sample data extraction rules file; uncomment and customize as necessary.
   See https://developer.android.com/about/versions/12/backup-restore#xml-changes
   for details.
-->
<data-extraction-rules>
    <cloud-backup>
        <!-- TODO: Use <include> and <exclude> to control what is backed up.
        <include .../>
        <exclude .../>
        -->
    </cloud-backup>
    <!--
    <device-transfer>
        <include .../>
        <exclude .../>
    </device-transfer>
    -->
</data-extraction-rules>
```

---

