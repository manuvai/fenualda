package core.character;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static com.sun.glass.events.KeyEvent.*;

public class Hero extends AbstractCharacter {
    private int points;

    private List<Integer> pressedKeys = new ArrayList<>();

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void keyReleased(KeyEvent e) {
        pressedKeys.remove((Object) e.getKeyCode());
        switch (e.getKeyCode()) {
            case VK_Z:
            case VK_UP:
                if (
                        !pressedKeys.contains(VK_Z) &&
                        !pressedKeys.contains(VK_UP) &&
                        !pressedKeys.contains(VK_S) &&
                        !pressedKeys.contains(VK_DOWN)
                ) {
                    setyDirection(CharacterDirection.STILL);

                } else if (
                        pressedKeys.contains(VK_S) ||
                        pressedKeys.contains(VK_DOWN)
                ) {
                    setyDirection(CharacterDirection.DOWN);
                }
                break;

            case VK_S:
            case VK_DOWN:
                if (
                        !pressedKeys.contains(VK_Z) &&
                        !pressedKeys.contains(VK_UP) &&
                        !pressedKeys.contains(VK_S) &&
                        !pressedKeys.contains(VK_DOWN)
                ) {
                    setyDirection(CharacterDirection.STILL);

                } else if (
                        pressedKeys.contains(VK_Z) ||
                        pressedKeys.contains(VK_UP)
                ) {
                    setyDirection(CharacterDirection.UP);
                }
                break;

            case VK_D:
            case VK_RIGHT:
                if (
                        !pressedKeys.contains(VK_D) &&
                        !pressedKeys.contains(VK_RIGHT) &&
                        !pressedKeys.contains(VK_Q) &&
                        !pressedKeys.contains(VK_LEFT)
                ) {
                    setxDirection(CharacterDirection.STILL);

                } else if (
                        pressedKeys.contains(VK_Q) ||
                        pressedKeys.contains(VK_LEFT)
                ) {
                    setxDirection(CharacterDirection.LEFT);
                }
                break;

            case VK_Q:
            case VK_LEFT:
                if (
                        !pressedKeys.contains(VK_D) &&
                        !pressedKeys.contains(VK_RIGHT) &&
                        !pressedKeys.contains(VK_Q) &&
                        !pressedKeys.contains(VK_LEFT)
                ) {
                    setxDirection(CharacterDirection.STILL);

                } else if (
                        pressedKeys.contains(VK_D) ||
                        pressedKeys.contains(VK_RIGHT)
                ) {
                    setxDirection(CharacterDirection.RIGHT);
                }
                break;
        }
    }

    public void keyPressed(KeyEvent e) {

        if (!pressedKeys.contains(e.getKeyCode())) {
            pressedKeys.add(e.getKeyCode());

        }

        switch (e.getKeyCode()) {
            case VK_Z:
            case VK_UP:
                setyDirection(CharacterDirection.UP);
                break;
            case VK_D:
            case VK_RIGHT:
                setxDirection(CharacterDirection.RIGHT);
                break;
            case VK_Q:
            case VK_LEFT:
                setxDirection(CharacterDirection.LEFT);
                break;
            case VK_S:
            case VK_DOWN:
                setyDirection(CharacterDirection.DOWN);
                break;
        }
    }
}
