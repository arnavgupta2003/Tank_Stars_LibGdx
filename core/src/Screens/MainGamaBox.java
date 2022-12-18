package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.extinct.tankstars.TankStars;

public class MainGamaBox implements Screen {
    TankStars game;
    public World world;
    public Box2DDebugRenderer debug;
    public OrthographicCamera camera;
    Body te;
    int l=0;
    Body tankHolder;
    Body tank2Holder;
    CircleShape s;
    CircleShape s2;
    Vector2 movement = new Vector2();
    Vector2 movement3 = new Vector2();
    ChainShape ground;
    Vector2 movement2 = new Vector2();
//    Texture gTex =  new Texture("C:\\Users\\91987\\Desktop\\.vscode\\AP Project\\assets\\assets\\Canyon_terrein_tile_8.png");
    Texture gTex = new Texture(Gdx.files.internal("Canyon_terrein_tile_8.png"));
    TextureRegion GroundReg = new TextureRegion(gTex);
    BodyDef tank2;
    BodyDef tank1;
//    float[] vertices = {-4200, 2, 3, 3, 57, 42, 25, 100};
//    short[] triangles = {0, 1, 2, 2, 3, 0};
//
//    PolygonRegion polygonRegion = new PolygonRegion(GroundReg, vertices, triangles);
//
//    // Create a polygon sprite from the polygon region
//    PolygonSprite sprite = new PolygonSprite(polygonRegion);
//
//    // Create a polygon sprite batch
//    PolygonSpriteBatch batch = new PolygonSpriteBatch();
//
//    SpriteBatch batchGround = new SpriteBatch();




    public MainGamaBox(TankStars game){
        this.game  = game;

    }

    public void createGround(){
        ground  = new ChainShape();
        BodyDef ball  = new BodyDef();
        ball.position.set(-2,5.5f); // 1 meter not pixel
        FixtureDef fex = new FixtureDef();
        fex.density = 2.5f;
        fex.friction = 0.45f;
        fex.restitution = 0.22f;
        ball.type = BodyDef.BodyType.StaticBody;
        ball.position.set(0,0);
        fex.friction = .5f;
        fex.restitution = 0;
        Vector2 vert  = new Vector2();
        vert.add(new Vector2(-4200,3));
        ground.createChain(new Vector2[]{
                new Vector2(-4200,3),
                new Vector2(-10.8f,4f),
                new Vector2(-10.4f,3.6f),
                new Vector2(-10.1f,3.4f),
                new Vector2(-9.9f,3.8f),

                new Vector2(-8.9f,4f),
                new Vector2(-8.6f,3.6f),
                new Vector2(-8.0f,3.4f),
                new Vector2(-7.6f,3.8f),

                new Vector2(-7.2f,4f),
                new Vector2(-6.8f,3.6f),
                new Vector2(-6.5f,3.4f),
                new Vector2(-5.9f,3.8f),

                new Vector2(-5.6f,4f),
                new Vector2(-5.2f,3.6f),
                new Vector2(-4.7f,3.4f),
                new Vector2(-4.6f,3.8f),

                new Vector2(-4.2f,4f),
                new Vector2(-4.0f,3.6f),
                new Vector2(-3.7f,3.4f),
                new Vector2(-3.4f,3.8f),


                new Vector2(-3.7f,4f),
                new Vector2(-3.5f,3.6f),
                new Vector2(-3.2f,3.4f),
                new Vector2(-2.9f,3.8f),

                new Vector2(-2.4f,4f),
                new Vector2(-2f,3.6f),
                new Vector2(-1.6f,3.4f),
                new Vector2(-1.2f,3.8f),

                new Vector2(-1f,4f),
                new Vector2(0f,3.6f),
                new Vector2(0.2f,3.4f),
                new Vector2(0.6f,3.8f),
                new Vector2(0.9f,3.5f),

                new Vector2(1f,3.6f),
                new Vector2(1.2f,3.4f),
                new Vector2(1.9f,3.8f),
                new Vector2(2.5f,3.5f),


                new Vector2(2.8f,3.6f),
                new Vector2(3.2f,3.4f),
                new Vector2(3.8f,3.8f),
                new Vector2(4.2f,3.5f),


                new Vector2(4.8f,3.6f),
                new Vector2(5.3f,3.4f),
                new Vector2(5.6f,3.8f),
                new Vector2(6.2f,3.5f),


                new Vector2(6.8f,3.6f),
                new Vector2(7.5f,3.4f),
                new Vector2(7.9f,3.8f),
                new Vector2(8.9f,3.5f),


                new Vector2(9.3f,3.6f),
                new Vector2(9.6f,3.4f),
                new Vector2(9.8f,3.8f),
                new Vector2(10.6f,3.5f),

                new Vector2(1000,4.2f)
        });


        fex.shape =  ground;
        world.createBody(ball).createFixture(fex);

    }

    public void tank1(){
        tank1  = new BodyDef();
        tank1.type = BodyDef.BodyType.DynamicBody;
        tank1.position.set(8.5f,10);
        final PolygonShape tank = new PolygonShape();
        FixtureDef fex = new FixtureDef();

        tank.setAsBox(.5f,1);

        fex.shape =  tank;
        fex.friction = .75f;
        fex.restitution = .1f;
        fex.density = 6;
        tankHolder =world.createBody(tank1);
        tank1.type = BodyDef.BodyType.DynamicBody;
        tankHolder.createFixture(fex);
//        Gdx.input.setInputProcessor(new InputController() {
//            @Override
//            public boolean keyDown(int keycode) {
//                    if(keycode == Input.Keys.A){
//                        tankHolder.setLinearVelocity(-10,0);
//                    }else if(keycode == Input.Keys.D){
//                        tankHolder.setLinearVelocity(10,0);
//                    }
//                    if(keycode == Input.Keys.F){
//                        Body b = world.createBody(bull);
//                            b.createFixture(bullFix);
//                            //b.applyForceToCenter(new Vector2(100,0),true);
//                            b.setLinearVelocity(new Vector2(-20, 5));
//                            te = b;
//                    }
//
//                return true;
//            }
//
//            @Override
//            public boolean keyUp(int keycode){
//                if(keycode == Input.Keys.A){
//                    tankHolder.setLinearVelocity(0,0);
//                }else if(keycode == Input.Keys.D){
//                    tankHolder.setLinearVelocity(0,0);
//                }
//                return true;
//
//            }
//
//        });

        tank.dispose();


    }
    public void tank2(){
        tank2 = new BodyDef();
        tank2.type = BodyDef.BodyType.DynamicBody;
        tank2.position.set(-8.5f,10);
        PolygonShape tank = new PolygonShape();
        FixtureDef fex = new FixtureDef();

        tank.setAsBox(.5f,1);
        final PolygonShape tanker = new PolygonShape();
        FixtureDef fex2 = new FixtureDef();

        tanker.setAsBox(.5f,1);


        fex.shape =  tank;
        fex.friction = .75f;
        fex.restitution = .1f;
        fex.density = 6;
        tank2Holder =world.createBody(tank2);
        tank2.type = BodyDef.BodyType.DynamicBody;
        tank2Holder.createFixture(fex);

    }

    @Override
    public void show() {
        this.world =  new World(new Vector2(0,-9.8f),true);// vector   2    is gravity vector
        debug =  new Box2DDebugRenderer();
        camera = new OrthographicCamera(Gdx.graphics.getHeight()/25,Gdx.graphics.getWidth()/25);
        createGround();
        tank1();
        tank2();

        final BodyDef bull2 =  new BodyDef();
        bull2.type = BodyDef.BodyType.DynamicBody;
        s2 =  new CircleShape();
        s2.setRadius(0.20f);
        final FixtureDef bullFix2 = new FixtureDef();
        bullFix2.shape = s2;

        bullFix2.density = 0.01f;

        bullFix2.restitution = 1.0f;
        final BodyDef bull =  new BodyDef();
        bull.type = BodyDef.BodyType.DynamicBody;
        s =  new CircleShape();
        s.setRadius(0.20f);
        final FixtureDef bullFix = new FixtureDef();
        bullFix.shape = s;

        bullFix.density = 0.01f;

        bullFix.restitution = 1.0f;

        Gdx.input.setInputProcessor(new InputController() {
            @Override
            public boolean keyDown(int keycode) {
                if(keycode == Input.Keys.LEFT){
                    tank2Holder.setLinearVelocity(-10,0);
                }else if(keycode == Input.Keys.RIGHT){
                    tank2Holder.setLinearVelocity(10,0);
                }
                else if(keycode == Input.Keys.H){
                    Body b2 = world.createBody(bull2);
                    b2.createFixture(bullFix2);
                    //b.applyForceToCenter(new Vector2(100,0),true);
                    b2.setLinearVelocity(new Vector2(20, 5));

                }
                else if(keycode == Input.Keys.A){
                        tankHolder.setLinearVelocity(-10,0);
                    }else if(keycode == Input.Keys.D){
                        tankHolder.setLinearVelocity(10,0);
                    }
                    else if(keycode == Input.Keys.F){
                        Body b = world.createBody(bull);
                            b.createFixture(bullFix);
                            //b.applyForceToCenter(new Vector2(100,0),true);
                            b.setLinearVelocity(new Vector2(-20, 5));
                            te = b;
                    }

                return true;
            }

            @Override
            public boolean keyUp(int keycode){
                if(keycode == Input.Keys.LEFT){
                    tank2Holder.setLinearVelocity(0,0);
                }else if(keycode == Input.Keys.RIGHT){
                    tank2Holder.setLinearVelocity(0,0);
                }

                return true;

            }

        });
//        final BodyDef bull =  new BodyDef();
//        bull.type = BodyDef.BodyType.DynamicBody;
//        s =  new CircleShape();
//        s.setRadius(0.20f);
//        final FixtureDef bullFix = new FixtureDef();
//        bullFix.shape = s;
//        bullFix.density = 0.01f;
//
//        bullFix.restitution = 1.0f;
//        Gdx.input.setInputProcessor(new InputController(){
//            @Override
//            public boolean keyDown(int keycode){
//                switch (keycode){
//                    case Input.Keys.D:
//                        movement.x = 100;
////
//                    case Input.Keys.A:
//                        movement.x = -100;
//
////
////                    case Input.Keys.F :
////
////                            Body b = world.createBody(bull);
////                            b.createFixture(bullFix);
////                            //b.applyForceToCenter(new Vector2(100,0),true);
////                            b.setLinearVelocity(new Vector2(-20, 5));
////                            te = b;
////                            l += 1;
////
//
//                    case Input.Keys.S:
//                        movement.x = 0;
//                }
//                return true;
//            }
//
//            @Override
//            public boolean keyUp(int keycode) {
//                switch(keycode){
//                    case Input.Keys.D:
//                        movement.x = 0;
//                    case Input.Keys.A:
//                        movement.x = 0;
//                    case Input.Keys.F:
//                        movement2.x = -10;
//
//
//                }
//                return true;
//            }
//        });
//        BodyDef ball  = new BodyDef();
//        BodyDef tank2 = new BodyDef();
//
//
//        ball.type =  BodyDef.BodyType.DynamicBody;
//        ball.position.set(-2,5.5f); // 1 meter not pixel
//        FixtureDef fex = new FixtureDef();
//        fex.density = 2.5f;
//        fex.friction = 0.45f;
//        fex.restitution = 0.22f;
//
//        CircleShape shape =  new CircleShape();
//        shape.setRadius(0.25f);
//        fex.shape =  shape;
//
//        shape.dispose();
//
//        // Ground
//        ball.type = BodyDef.BodyType.StaticBody;
//        ball.position.set(0,0);
//        fex.friction = .5f;
//        fex.restitution = 0;
//
//        ground =  new ChainShape();
//
//        ground.createChain(new Vector2[] {new Vector2(-100,2),new Vector2(4200,3)});
//        GroundReg.setRegion(0,0,gTex.getWidth(),gTex.getHeight());
//        //,new Vector2(3,3),new Vector2(4,4),new Vector2(5,3),new Vector2(6,3),new Vector2(8,4),new Vector2(4000f,3.5f)});
//        fex.shape =  ground;
//        world.createBody(ball).createFixture(fex);
//        ground.dispose();
//
//        ball.type = BodyDef.BodyType.DynamicBody;
//        ball.position.set(5.5f,10);
//        PolygonShape tank = new PolygonShape();
//        PolygonShape tankr = new PolygonShape();
//        tank.setAsBox(.5f,1);
//        tankr.setAsBox(.5f,1);
//        fex.shape =  tank;
//        fex.friction = .75f;
//        fex.restitution = .1f;
//        fex.density = 6;
//        tankHolder =world.createBody(ball);
//        tank2.type = BodyDef.BodyType.DynamicBody;
//        tank2.position.set(2.5f,10);
//        tank2Holder = world.createBody(tank2);
//        tankHolder.createFixture(fex);
//        tank2Holder.createFixture(fex);
//
//        tank.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
        world.step(1/60f,8,3);
        tankHolder.applyForceToCenter(movement,true);
        tankHolder.applyLinearImpulse(movement2,new Vector2(tankHolder.getPosition().x,tankHolder.getPosition().y),true);

        tank2Holder.applyForceToCenter(movement3,true);
        tank2Holder.applyLinearImpulse(movement2,new Vector2(tank2Holder.getPosition().x +2,tank2Holder.getPosition().y+2),true);
//        l=0;
//        if(l==1) {
//            camera.position.set(tankHolder.getPosition().x, tankHolder.getPosition().y, 0);
//
//        }
//        else{
//            camera.position.set(tank2Holder.getPosition().x, tank2Holder.getPosition().y, 0);
//
//        }
        s.setPosition(new Vector2(tankHolder.getPosition().x,tankHolder.getPosition().y));

        s2.setPosition(new Vector2(tank2Holder.getPosition().x,tank2Holder.getPosition().y));
//
//
//        movement2.x = 0;
//        camera.update();
        debug.render(world,camera.combined);
//        batch.begin();
//        batch.draw(polygonRegion, 20, 20);
//        batch.end();



    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        world.dispose();
        debug.dispose();

    }
}
