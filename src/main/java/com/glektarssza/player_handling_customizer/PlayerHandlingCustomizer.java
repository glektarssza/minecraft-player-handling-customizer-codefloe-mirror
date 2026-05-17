package com.glektarssza.player_handling_customizer;

import java.util.Optional;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

import com.glektarssza.player_handling_customizer.api.annotations.Nullable;

@Mod(
    modid = Tags.MOD_ID,
    name = Tags.MOD_NAME,
    version = Tags.MOD_VERSION,
    dependencies = Tags.MOD_DEPENDENCIES,
    acceptedMinecraftVersions = Tags.MINECRAFT_VERSION_RANGE,
    acceptableSaveVersions = Tags.MOD_ACCEPTED_SAVE_VERSION_RANGE,
    acceptableRemoteVersions = Tags.MOD_ACCEPTED_REMOTE_VERSION_RANGE,
    updateJSON = Tags.UPDATE_MANIFEST_URL,
    guiFactory = Tags.MOD_GUI_FACTORY,
    certificateFingerprint = Tags.MOD_SIGNATURE,
    modLanguage = "java",
    canBeDeactivated = false,
    serverSideOnly = false,
    clientSideOnly = false,
    useMetadata = true
)
public final class PlayerHandlingCustomizer {
    /**
     * The mod instance.
     */
    @Mod.Instance
    @Nullable
    private static PlayerHandlingCustomizer instance = null;

    /**
     * The logger instance for the mod.
     */
    @Nullable
    private static Logger logger = null;

    @SidedProxy(
        clientSide = Tags.MOD_SIDED_PROXY_CLIENT_SIDE,
        serverSide = Tags.MOD_SIDED_PROXY_SERVER_SIDE
    )
    @Nullable
    private static CommonProxy sidedProxy = null;

    /**
     * Try to get the {@link Logger} instance for the mod.
     *
     * @return An {@link Optional} which may hold the {@link Logger} instance
     *         for the mod.
     */
    public static Optional<Logger> tryGetLogger() {
        return Optional.ofNullable(logger);
    }

    /**
     * Get the {@link Logger} instance for the mod.
     *
     * @return The {@link Logger} instance for the mod.
     *
     * @throws NullPointerException Thrown if the mod {@link Logger} does not
     *         exist.
     */
    public static Logger getLogger() throws NullPointerException {
        return tryGetLogger()
            .orElseThrow(
                () -> new NullPointerException(
                    "Mod logger instance does not exist"
                )
            );
    }

    /**
     * Try to get the {@link CommonProxy} instance for the mod.
     *
     * @return An {@link Optional} which may hold the {@link CommonProxy}
     *         instance for the mod.
     */
    public static Optional<CommonProxy> tryGetSidedProxy() {
        return Optional.ofNullable(sidedProxy);
    }

    /**
     * Get the {@link CommonProxy} instance for the mod.
     *
     * @return The {@link CommonProxy} instance for the mod.
     *
     * @throws NullPointerException Thrown if the mod {@link CommonProxy} does
     *         not exist.
     */
    public static CommonProxy getSidedProxy() throws NullPointerException {
        return tryGetSidedProxy()
            .orElseThrow(
                () -> new NullPointerException(
                    String
                        .format(
                            "Sided proxy instance for mod with ID \"{}\" does not exist",
                            Tags.MOD_ID
                        )
                )
            );
    }

    /**
     * Handle the pre-initialization event from the Forge mod loader.
     *
     * @param event The event to handle.
     *
     * @throws RuntimeException Thrown if the mod fails to initialize due to
     *         unforeseen circumstances.
     */
    @Mod.EventHandler
    public void OnPreInit(
        FMLPreInitializationEvent event
    ) throws RuntimeException {
        logger = event.getModLog();
        getLogger()
            .info(
                "Performing pre-initialization logic for mod ID \"{}\"...",
                Tags.MOD_ID
            );
        try {
            getSidedProxy().OnPreInit(event);
        } catch (Exception ex) {
            getLogger()
                .fatal(
                    "Fatal error during pre-initialization logic for mod ID \"{}\"",
                    Tags.MOD_ID
                );
            getLogger().fatal(ex);
            throw new RuntimeException(
                String
                    .format(
                        "Fatal exception during pre-initialization logic for mod with ID \"%s\"",
                        Tags.MOD_ID
                    ),
                ex
            );
        }
        getLogger()
            .info(
                "Pre-initialization logic for mod ID \"{}\" completed normally",
                Tags.MOD_ID
            );
    }

    /**
     * Handle the main initialization event from the Forge mod loader.
     *
     * @param event The event to handle.
     */
    @Mod.EventHandler
    public void OnInit(FMLInitializationEvent event) {
        getLogger()
            .info(
                "Performing main initialization logic for mod ID \"{}\"...",
                Tags.MOD_ID
            );
        try {
            getSidedProxy().OnInit(event);
        } catch (Exception ex) {
            getLogger()
                .fatal(
                    "Fatal error during main initialization logic for mod ID \"{}\"",
                    Tags.MOD_ID
                );
            getLogger().fatal(ex);
            throw new RuntimeException(
                String
                    .format(
                        "Fatal exception during initialization logic for mod with ID \"%s\"",
                        Tags.MOD_ID
                    ),
                ex
            );
        }
        getLogger()
            .info(
                "Main initialization logic for mod ID \"{}\" completed normally",
                Tags.MOD_ID
            );
    }

    /**
     * Handle the post-initialization event from the Forge mod loader.
     *
     * @param event The event to handle.
     */
    @Mod.EventHandler
    public void OnPostInit(FMLPostInitializationEvent event) {
        getLogger()
            .info(
                "Performing post-initialization logic for mod ID \"{}\"...",
                Tags.MOD_ID
            );
        try {
            getSidedProxy().OnPostInit(event);
        } catch (Exception ex) {
            getLogger()
                .fatal(
                    "Fatal error during post-initialization logic for mod ID \"{}\"",
                    Tags.MOD_ID
                );
            getLogger().fatal(ex);
            throw new RuntimeException(
                String
                    .format(
                        "Fatal exception during post-initialization logic for mod with ID \"%s\"",
                        Tags.MOD_ID
                    ),
                ex
            );
        }
        getLogger()
            .info(
                "Post-initialization logic for mod ID \"{}\" completed normally",
                Tags.MOD_ID
            );
    }

    /**
     * Handle the event indicating the server is about to start from the Forge
     * mod loader.
     *
     * @param event The event to handle.
     */
    @Mod.EventHandler
    public void OnServerAboutToStart(FMLServerAboutToStartEvent event) {
        getLogger()
            .info(
                "Performing \"server about to start\" logic for mod ID \"{}\"...",
                Tags.MOD_ID
            );
        try {
            getSidedProxy().OnServerAboutToStart(event);
        } catch (Exception ex) {
            getLogger()
                .fatal(
                    "Fatal error during \"server about to start\" logic for mod ID \"{}\"",
                    Tags.MOD_ID
                );
            getLogger().fatal(ex);
            throw new RuntimeException(
                String
                    .format(
                        "Fatal exception during server \"about to start\" logic for mod with ID \"%s\"",
                        Tags.MOD_ID
                    ),
                ex
            );
        }
        getLogger()
            .info(
                "Post-initialization logic for mod ID \"{}\" completed normally",
                Tags.MOD_ID
            );
    }

    /**
     * Handle the event indicating the server starting from the Forge mod
     * loader.
     *
     * @param event The event to handle.
     */
    @Mod.EventHandler
    public void OnServerStarting(FMLServerStartingEvent event) {
        getLogger()
            .info(
                "Performing \"server starting\" logic for mod ID \"{}\"...",
                Tags.MOD_ID
            );
        try {
            getSidedProxy().OnServerStarting(event);
        } catch (Exception ex) {
            getLogger()
                .fatal(
                    "Fatal error during \"server starting\" logic for mod ID \"{}\"",
                    Tags.MOD_ID
                );
            getLogger().fatal(ex);
            throw new RuntimeException(
                String
                    .format(
                        "Fatal exception during server \"server starting\" logic for mod with ID \"%s\"",
                        Tags.MOD_ID
                    ),
                ex
            );
        }
        getLogger()
            .info(
                "Server starting logic for mod ID \"{}\" completed normally",
                Tags.MOD_ID
            );
    }

    /**
     * Handle the event indicating the server has started from the Forge mod
     * loader.
     *
     * @param event The event to handle.
     */
    @Mod.EventHandler
    public void OnServerStarted(FMLServerStartedEvent event) {
        getLogger()
            .info(
                "Performing \"server started\" logic for mod ID \"{}\"...",
                Tags.MOD_ID
            );
        try {
            getSidedProxy().OnServerStarted(event);
        } catch (Exception ex) {
            getLogger()
                .fatal(
                    "Fatal error during \"server started\" logic for mod ID \"{}\"",
                    Tags.MOD_ID
                );
            getLogger().fatal(ex);
            throw new RuntimeException(
                String
                    .format(
                        "Fatal exception during server \"server started\" logic for mod with ID \"%s\"",
                        Tags.MOD_ID
                    ),
                ex
            );
        }
        getLogger()
            .info(
                "Server started logic for mod ID \"{}\" completed normally",
                Tags.MOD_ID
            );
    }

    /**
     * Handle the event indicating the server stopping from the Forge mod
     * loader.
     *
     * @param event The event to handle.
     */
    @Mod.EventHandler
    public void OnServerStopping(FMLServerStoppingEvent event) {
        getLogger()
            .info(
                "Performing \"server stopping\" logic for mod ID \"{}\"...",
                Tags.MOD_ID
            );
        try {
            getSidedProxy().OnServerStopping(event);
        } catch (Exception ex) {
            getLogger()
                .fatal(
                    "Fatal error during \"server stopping\" logic for mod ID \"{}\"",
                    Tags.MOD_ID
                );
            getLogger().fatal(ex);
            throw new RuntimeException(
                String
                    .format(
                        "Fatal exception during server \"server stopping\" logic for mod with ID \"%s\"",
                        Tags.MOD_ID
                    ),
                ex
            );
        }
        getLogger()
            .info(
                "Server stopping logic for mod ID \"{}\" completed normally",
                Tags.MOD_ID
            );
    }

    /**
     * Handle the event indicating the server has stopped from the Forge mod
     * loader.
     *
     * @param event The event to handle.
     */
    @Mod.EventHandler
    public void OnServerStopped(FMLServerStoppedEvent event) {
        getLogger()
            .info(
                "Performing \"server stopped\" logic for mod ID \"{}\"...",
                Tags.MOD_ID
            );
        try {
            getSidedProxy().OnServerStopped(event);
        } catch (Exception ex) {
            getLogger()
                .fatal(
                    "Fatal error during \"server stopped\" logic for mod ID \"{}\"",
                    Tags.MOD_ID
                );
            getLogger().fatal(ex);
            throw new RuntimeException(
                String
                    .format(
                        "Fatal exception during server \"server stopped\" logic for mod with ID \"%s\"",
                        Tags.MOD_ID
                    ),
                ex
            );
        }
        getLogger()
            .info(
                "Server stopped logic for mod ID \"{}\" completed normally",
                Tags.MOD_ID
            );
    }
}
