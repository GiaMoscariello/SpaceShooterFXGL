package com.jimminor.componentes;
import com.almasb.fxgl.entity.component.Component;

public class WeaponComponent extends Component {

    private String name;
    private double speed;

    public WeaponComponent(double speed) {
        this.speed = speed;
    }
    @Override
    public void onUpdate(double tpf) {
        entity.translateY( -tpf * speed);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed () {
        return speed;
    }

    public void setSpeed (double speed) {
        this.speed = speed;
    }

    public void shoot () {

    }
}
