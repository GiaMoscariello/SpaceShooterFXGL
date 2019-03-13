package com.jimminor.componentes;

import com.almasb.fxgl.entity.*;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.extra.entity.components.OffscreenCleanComponent;
import com.almasb.fxgl.extra.entity.components.ProjectileComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import javafx.geometry.Point2D;

public class ShipFactory implements EntityFactory {

    @Spawns("myShip") public Entity newMyShip(SpawnData data) {
        EngineComponent engine = new EngineComponent();
        WeaponComponent weapon = new WeaponComponent(600);

        weapon.setSpeed(5);
        weapon.setName("primary");
        engine.setPower(5);

        return Entities.builder()
                .from(data)
                .type(SpaceEntity.MYSHIP)
                .viewFromTextureWithBBox("player.png")
                .bbox(new HitBox(BoundingShape.box(99,75)))
                .with(new CollidableComponent(true))
                .with(engine)
                .build();
    }

    @Spawns("enemyShip") public Entity newEnemyShip(SpawnData data) {
        EngineComponent engine = new EngineComponent();
        engine.setPower(2.5);

        WeaponComponent weapon1= new WeaponComponent(600);
        weapon1.setName("primary");
        weapon1.setSpeed(20);


        return Entities.builder()
                .from(data)
                .type(SpaceEntity.ENEMY_SHIP)
                .viewFromTextureWithBBox("enemyShip.png")
                .with(new CollidableComponent(true))
                .with(engine)
                .bbox(new HitBox(BoundingShape.box(98,50)))
                .build();
    }

    @Spawns("bullet") public Entity newBullet(SpawnData data) {
       return Entities.builder()
               .from(data)
               .type(SpaceEntity.BULLET)
               .viewFromTextureWithBBox("laserGreen.png")
               .bbox(new HitBox(BoundingShape.box(9,33)))
		       .with(new ProjectileComponent(new Point2D(0,-1),300), new OffscreenCleanComponent())
               .build();


    }
}
