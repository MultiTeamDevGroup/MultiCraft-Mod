package yourModPackage.common.animations.Pigeon;

import yourModPackage.common.MCACommonLibrary.animation.*;
import yourModPackage.common.MCACommonLibrary.math.*;

public class ChannelFly extends Channel {
	public ChannelFly(String _name, float _fps, int _totalFrames, byte _mode) {
		super(_name, _fps, _totalFrames, _mode);
	}

	@Override
	protected void initializeAllFrames() {
KeyFrame frame0 = new KeyFrame();
frame0.modelRenderersRotations.put("feet1", new Quaternion(-0.45554492F, 0.0F, 0.0F, 0.89021283F));
frame0.modelRenderersRotations.put("leg2", new Quaternion(-0.45554492F, 0.0F, 0.0F, 0.89021283F));
frame0.modelRenderersRotations.put("feet2", new Quaternion(-0.45554492F, 0.0F, 0.0F, 0.89021283F));
frame0.modelRenderersRotations.put("tail", new Quaternion(-0.050592944F, 0.0F, 0.0F, 0.99871933F));
frame0.modelRenderersRotations.put("body", new Quaternion(0.067144625F, 0.0F, 0.0F, 0.99774325F));
frame0.modelRenderersRotations.put("wing1", new Quaternion(0.40627462F, -0.44647437F, -0.5257303F, 0.5993407F));
frame0.modelRenderersRotations.put("leg1", new Quaternion(-0.45554492F, 0.0F, 0.0F, 0.89021283F));
frame0.modelRenderersRotations.put("wing2", new Quaternion(0.40627614F, 0.4464757F, 0.5257292F, 0.5993396F));
frame0.modelRenderersTranslations.put("feet1", new Vector3f(-1.0F, -19.0F, 1.0F));
frame0.modelRenderersTranslations.put("leg2", new Vector3f(1.0F, -19.0F, 1.0F));
frame0.modelRenderersTranslations.put("feet2", new Vector3f(-1.0F, -19.0F, 1.0F));
frame0.modelRenderersTranslations.put("tail", new Vector3f(0.0F, -18.0F, 4.0F));
frame0.modelRenderersTranslations.put("body", new Vector3f(0.0F, -16.0F, -1.0F));
frame0.modelRenderersTranslations.put("wing1", new Vector3f(-1.0F, -18.0F, 1.0F));
frame0.modelRenderersTranslations.put("leg1", new Vector3f(-1.0F, -19.0F, 1.0F));
frame0.modelRenderersTranslations.put("wing2", new Vector3f(1.0F, -18.0F, 1.0F));
keyFrames.put(0, frame0);

KeyFrame frame3 = new KeyFrame();
frame3.modelRenderersRotations.put("wing1", new Quaternion(0.38183263F, -0.38183263F, -0.20431909F, 0.8164934F));
frame3.modelRenderersRotations.put("wing2", new Quaternion(0.38183263F, 0.38183263F, 0.20431909F, 0.8164934F));
frame3.modelRenderersTranslations.put("wing1", new Vector3f(-1.0F, -18.0F, 1.0F));
frame3.modelRenderersTranslations.put("wing2", new Vector3f(1.0F, -18.0F, 1.0F));
keyFrames.put(3, frame3);

KeyFrame frame6 = new KeyFrame();
frame6.modelRenderersRotations.put("wing1", new Quaternion(0.40627462F, -0.44647437F, -0.5257303F, 0.5993407F));
frame6.modelRenderersRotations.put("wing2", new Quaternion(0.40627614F, 0.4464757F, 0.5257292F, 0.5993396F));
frame6.modelRenderersTranslations.put("wing1", new Vector3f(-1.0F, -18.0F, 1.0F));
frame6.modelRenderersTranslations.put("wing2", new Vector3f(1.0F, -18.0F, 1.0F));
keyFrames.put(6, frame6);

}
}