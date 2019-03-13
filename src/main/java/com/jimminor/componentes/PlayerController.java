package com.jimminor.componentes;

import com.almasb.fxgl.entity.component.Component;

public class PlayerController extends Component {

	private PlayerComponent ship;

	public void up() {

	}
	public PlayerComponent getShip () {
		return ship;
	}

	public void setShip (PlayerComponent ship) {
		this.ship = ship;
	}
}
