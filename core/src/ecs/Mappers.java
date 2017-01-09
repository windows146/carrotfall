package ecs;

import com.badlogic.ashley.core.ComponentMapper;

import ecs.components.PhysicsComponent;
import ecs.components.PositionComponent;

/**
 * Created by jeast on 1/8/2017.
 */

public class Mappers {
    public static final ComponentMapper<PhysicsComponent> physicsComponentMapper = ComponentMapper.getFor(PhysicsComponent.class);
    public static final ComponentMapper<PositionComponent> positionComponentMapper = ComponentMapper.getFor(PositionComponent.class);
}
