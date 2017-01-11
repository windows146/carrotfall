package ecs;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import ecs.components.PhysicsComponent;

/**
 * Created by jeast on 1/11/2017.
 */

public class CarrotFactory {
    public CarrotFactory(Engine ashleyEngine, World box2DWorld, Vector2 carrotPosition) {
        Entity carrotEntity = new Entity();

        carrotEntity.add(new PhysicsComponent());

        Mappers.physicsComponentMapper.get(carrotEntity).bodyDef = new BodyDef();
        Mappers.physicsComponentMapper.get(carrotEntity).bodyDef.type = BodyDef.BodyType.DynamicBody;
        Mappers.physicsComponentMapper.get(carrotEntity).bodyDef.position.set(carrotPosition.x, carrotPosition.y);

        Mappers.physicsComponentMapper.get(carrotEntity).body = box2DWorld.createBody(Mappers.physicsComponentMapper.get(carrotEntity).bodyDef);

        PolygonShape boxShape = new PolygonShape();
        boxShape.setAsBox(70, 20);

        Mappers.physicsComponentMapper.get(carrotEntity).fixtureDef = new FixtureDef();
        Mappers.physicsComponentMapper.get(carrotEntity).fixtureDef.shape = boxShape;
        Mappers.physicsComponentMapper.get(carrotEntity).fixtureDef.density = 0.05f;
        Mappers.physicsComponentMapper.get(carrotEntity).fixtureDef.friction = 0.05f;
        Mappers.physicsComponentMapper.get(carrotEntity).fixtureDef.restitution = 0.29f;

        Mappers.physicsComponentMapper.get(carrotEntity).fixture = Mappers.physicsComponentMapper.get(carrotEntity).body.createFixture(Mappers.physicsComponentMapper.get(carrotEntity).fixtureDef);

        boxShape.dispose();

        ashleyEngine.addEntity(carrotEntity);
    }
}