package Screens;

import Game.ScreenCoordinator;
import Level.Map;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Maps.moonValleyTitle;

public class DebugMenuScreen extends AbstractMenuScreen {
    public static final boolean DEBUG_ENABLED = true;

    public static class SwitchMapOption extends Option {
        @Override
        public String getText() {
            return "switch maps";
        }

        @Override
        public void select(AbstractMenuScreen parent) {
            parent.screenCoordinator.push(new AbstractMenuScreen(parent.screenCoordinator) {
                class MapOption extends Option {
                    Map map;

                    public MapOption(Map map) {
                        this.map = map;
                    }

                    @Override
                    public String getText() {
                        return this.map.getMapFileName();
                    }

                    @Override
                    public void select(AbstractMenuScreen parent) {
                        parent.screenCoordinator.getPlayLevelScreen().teleport(this.map, 0, 0);
                        parent.screenCoordinator.dropUntil(parent.screenCoordinator.getPlayLevelScreen());
                    }
                }

                @Override
                public void addOptions() {
                    this.options.add(new MapOption(new TitleScreenMap()));
                    this.options.add(new MapOption(new moonValleyTitle()));
                    this.options.add(new MapOption(new TestMap()));
                    this.options.add(new CancelOption());
                }
            });
        }

    }

    public DebugMenuScreen(ScreenCoordinator screenCoordinator) {
        super(screenCoordinator);
    }

    @Override
    public String getTitle() {
        return "Debug Menu";
    }

    @Override
    public void initialize() {
        if (!DEBUG_ENABLED) {
            this.screenCoordinator.pop(this);
        } else {
            super.initialize();
        }
    }

    @Override
    public void addOptions() {
        this.options.add(new SwitchMapOption());
        this.options.add(new CancelOption());
    }
}
