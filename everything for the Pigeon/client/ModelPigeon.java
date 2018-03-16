package yourModPackage.client.models;

import java.util.HashMap;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

import yourModPackage.client.MCAClientLibrary.MCAModelRenderer;
import yourModPackage.common.MCACommonLibrary.MCAVersionChecker;
import yourModPackage.common.MCACommonLibrary.animation.AnimationHandler;
import yourModPackage.common.MCACommonLibrary.math.Matrix4f;
import yourModPackage.common.MCACommonLibrary.math.Quaternion;
import yourModPackage.common.entities.mobs.EntityPigeon;

public class ModelPigeon extends ModelBase {
public final int MCA_MIN_REQUESTED_VERSION = 5;
public HashMap<String, MCAModelRenderer> parts = new HashMap<String, MCAModelRenderer>();

MCAModelRenderer head;
MCAModelRenderer body;
MCAModelRenderer wing1;
MCAModelRenderer wing2;
MCAModelRenderer tail;
MCAModelRenderer beak;
MCAModelRenderer leg1;
MCAModelRenderer feet1;
MCAModelRenderer leg2;
MCAModelRenderer feet2;

public ModelPigeon()
{
MCAVersionChecker.checkForLibraryVersion(getClass(), MCA_MIN_REQUESTED_VERSION);

textureWidth = 64;
textureHeight = 64;

head = new MCAModelRenderer(this, "head", 12, 9);
head.mirror = false;
head.addBox(-1.5F, -1.0F, -2.0F, 3, 3, 3);
head.setInitialRotationPoint(0.0F, -16.0F, -1.0F);
head.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
head.setTextureSize(64, 64);
parts.put(head.boxName, head);

body = new MCAModelRenderer(this, "body", 0, 0);
body.mirror = false;
body.addBox(-1.5F, -3.0F, -0.0F, 3, 3, 6);
body.setInitialRotationPoint(0.0F, -16.0F, -1.0F);
body.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.14816688F, 0.0F, 0.0F, 0.98896235F)).transpose());
body.setTextureSize(64, 64);
parts.put(body.boxName, body);

wing1 = new MCAModelRenderer(this, "wing1", 0, 9);
wing1.mirror = false;
wing1.addBox(-1.5F, -2.2F, -0.0F, 1, 3, 5);
wing1.setInitialRotationPoint(-1.0F, -17.0F, -1.0F);
wing1.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.07428872F, 0.0F, 0.0F, 0.9972368F)).transpose());
wing1.setTextureSize(64, 64);
parts.put(wing1.boxName, wing1);

wing2 = new MCAModelRenderer(this, "wing2", 0, 17);
wing2.mirror = false;
wing2.addBox(0.5F, -2.2F, -0.0F, 1, 3, 5);
wing2.setInitialRotationPoint(1.0F, -17.0F, -1.0F);
wing2.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.07428872F, 0.0F, 0.0F, 0.9972368F)).transpose());
wing2.setTextureSize(64, 64);
parts.put(wing2.boxName, wing2);

tail = new MCAModelRenderer(this, "tail", 18, 0);
tail.mirror = false;
tail.addBox(-1.5F, -1.0F, -0.0F, 3, 1, 4);
tail.setInitialRotationPoint(0.0F, -18.0F, 4.0F);
tail.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
tail.setTextureSize(64, 64);
parts.put(tail.boxName, tail);

beak = new MCAModelRenderer(this, "beak", 18, 5);
beak.mirror = false;
beak.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 1);
beak.setInitialRotationPoint(0.0F, -16.0F, -1.0F);
beak.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
beak.setTextureSize(64, 64);
parts.put(beak.boxName, beak);

leg1 = new MCAModelRenderer(this, "leg1", 32, 0);
leg1.mirror = false;
leg1.addBox(-0.5F, -3.0F, -0.0F, 1, 3, 0);
leg1.setInitialRotationPoint(-1.0F, -19.0F, 1.0F);
leg1.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
leg1.setTextureSize(64, 64);
parts.put(leg1.boxName, leg1);

feet1 = new MCAModelRenderer(this, "feet1", 32, 0);
feet1.mirror = false;
feet1.addBox(-0.5F, -2.999F, -1.0F, 1, 0, 1);
feet1.setInitialRotationPoint(-1.0F, -19.0F, 1.0F);
feet1.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
feet1.setTextureSize(64, 64);
parts.put(feet1.boxName, feet1);

leg2 = new MCAModelRenderer(this, "leg2", 32, 0);
leg2.mirror = false;
leg2.addBox(-0.5F, -3.0F, -0.0F, 1, 3, 0);
leg2.setInitialRotationPoint(1.0F, -19.0F, 1.0F);
leg2.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
leg2.setTextureSize(64, 64);
parts.put(leg2.boxName, leg2);

feet2 = new MCAModelRenderer(this, "feet2", 32, 0);
feet2.mirror = false;
feet2.addBox(1.5F, -2.999F, -1.0F, 1, 0, 1);
feet2.setInitialRotationPoint(-1.0F, -19.0F, 1.0F);
feet2.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
feet2.setTextureSize(64, 64);
parts.put(feet2.boxName, feet2);

}

@Override
public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) 
{
EntityPigeon entity = (EntityPigeon)par1Entity;

AnimationHandler.performAnimationInModel(parts, entity);

//Render every non-child part
head.render(par7);
body.render(par7);
wing1.render(par7);
wing2.render(par7);
tail.render(par7);
beak.render(par7);
leg1.render(par7);
feet1.render(par7);
leg2.render(par7);
feet2.render(par7);
}
@Override
public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {}

public MCAModelRenderer getModelRendererFromName(String name)
{
return parts.get(name);
}
}