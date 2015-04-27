package moe.nightfall.vic.integratedcircuits.ic.part;

import moe.nightfall.vic.integratedcircuits.ic.CircuitPart;
import moe.nightfall.vic.integratedcircuits.ic.ICircuit;
import moe.nightfall.vic.integratedcircuits.misc.Vec2;
import net.minecraftforge.common.util.ForgeDirection;

import static moe.nightfall.vic.integratedcircuits.ic.CircuitPartRenderer.addQuad;

public class PartNull extends CircuitPart {
	@Override
	public void onPlaced(Vec2 pos, ICircuit parent) {
		for (int i = 2; i < 6; i++) {
			ForgeDirection fd = ForgeDirection.getOrientation(i);
			CircuitPart part = getNeighbourOnSide(pos, parent, fd);
			part.onInputChange(pos.offset(fd), parent, fd.getOpposite());
		}
	}

	@Override
	public void renderPart(Vec2 pos, ICircuit parent, double x, double y, int type) {

	}
}
