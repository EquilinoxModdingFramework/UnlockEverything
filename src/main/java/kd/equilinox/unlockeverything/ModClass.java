package kd.equilinox.unlockeverything;

import gameManaging.GameManager;
import kd.equilinox.events.sessions.PostLoadSessionEvent;
import kd.equilinox.mods.IMod;
import mainGuis.EquilinoxGuis;
import mainGuis.GuiRepository;
import shops.ShopItem;
import tasks.Task;

/**
 * Mod which unlocks everything in the game.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 */
public class ModClass implements IMod {
	public String getModName() {
		return "Unlock Everything";
	}

	public void postLoadSession(PostLoadSessionEvent event) {
		for (ShopItem item : GameManager.getShops().getPlantShop().getShopStock()) {
			item.unlock();
		}
		for (ShopItem item : GameManager.getShops().getAnimalShop().getShopStock()) {
			item.unlock();
		}
		for (Task task : GameManager.getTaskManager().getTasks()) {
			task.unlock();
		}
		EquilinoxGuis.notify("[Unlock Everything]", "Everything is now unlocked.", GuiRepository.UNLOCKED, null);
	}
}
