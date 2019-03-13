package com.jimminor.componentes;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.component.Required;
import com.almasb.fxgl.entity.components.PositionComponent;
import com.almasb.fxgl.input.ActionType;
import com.almasb.fxgl.input.OnUserAction;

public class EngineComponent extends Component{
    private double power;

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

}
