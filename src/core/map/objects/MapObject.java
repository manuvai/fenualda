package core.map.objects;

import core.character.Hero;
import core.impl.effects.Effect;
import core.map.AbstractMapComponent;

public class MapObject extends AbstractMapComponent {
    private Effect effect;

    public void use(Hero hero) {
        if (effect == null) {
            return;
        }

        effect.affect(hero);
    }

    /*
        Getters & Setters
     */

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }
}
