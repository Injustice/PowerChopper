package org.injustice.powerchopper.util;

import org.powerbot.game.api.util.Timer;

public class Variables {

	public static String status, chopping;
	public static boolean guiDone = false, hidePaint = false,
			actionBarDrop = true;
	public static int startExp, startLevel, logsCut, logsBurned, startInventCount;
    public static int startFMexp, startFMlevel;
	public static Timer runTime = new Timer(0);
	public static int log; // Inventory ID
	public static int tree[]; // Tree ID
    public static int nestsPicked = 0;
    public static int antibanCount = 0;

    // Bonfires
    public static final int[] BONFIRES_ID = { 70755, 70757, 70758, 70761, 70764, 70765 };


	// Inventory IDs
	public static final int NORMAL = 1511;
	public static final int MAGIC = 1513;
	public static final int YEW = 1515;
	public static final int MAPLE = 1517;
	public static final int WILLOW = 1519;
	public static final int OAK = 1521;
	public static final int ACHEY = 2862;
	public static final int ARCTIC_PINE = 10810;
	public static final int EUCALYPTUS = 12581;

	// Tree IDs
	public static final int[] NORMAL_ID = { 38760, 38782, 38783, 38785, 38787, 38788 };
	public static final int[] ACHEY_ID = { 2023, 29088, 29089, 29090 };
	public static final int[] EUCALYPTUS_ID = { 28951, 28952, 28953 };
	public static final int[] ARCTIC_PINE_ID = { 70057 };
	public static final int[] OAK_ID = {1281, 3037, 8462, 8463, 8464, 8465, 8466, 8467, 10083, 11999, 13413, 13420, 37479,
            38381, 38731, 38732, 38736, 38739, 38754, 51675 };
	public static final int[] WILLOW_ID = {139, 142, 2210, 2372, 8481, 8482, 8483, 8484, 8485, 8486, 8487, 8488, 13414, 13421,
            37480, 38616, 38627, 38717, 38718, 51682, 58006 };
	public static final int[] MAPLE_ID = {1307, 4674, 8435, 8436, 8437, 8438, 8439, 8440, 8441, 8442, 8443, 8444, 13415, 13423,
            46277, 51843 };
	public static final int[] YEW_ID = {1309, 8503, 8504, 8506, 8507, 8508, 8509, 8510, 8511, 8512, 8513, 12000, 13416, 13422,
            38755, 38758, 38759, 46278, 51645};
	public static final int[] MAGIC_ID = {1306, 8396, 8397, 8398, 8399, 8400, 8401, 8402, 8403, 8404, 8405, 8406, 8407, 8408,
            8409, 13417, 13424, 37823, 51833 };
	public static final int[] IVY_ID = { 11686, 46322, 46320, 46318, 40320, 46324, 675, 470, 670, 673, 46324, 46421 };

    // Bools

    public static boolean actionDrop = true;
    public static boolean noPaint = false;
    public static boolean simplePaint = true;
    public static boolean sexyPaint = false;
    public static boolean normalDrop = false;
    public static boolean pickNests = false;
    public static boolean nestExists = false;
    public static boolean doBonfires = false;
    public static boolean noMouse = true;
    public static boolean doAntiban = false;
    public static boolean doScreenshots = false;
    public static boolean normalChop = false;
    public static boolean showWCexp = true;
    public static boolean showFMexp = false;
    public static boolean currentlyDoingBonfires = false;

    // Other

    public static final int[] NESTS = {5070, 5071, 5072, 5073, 5074, 5075, 7413, 11966 };
    public static int antibanPercent = 0;
    public static final int FIRE_SPIRIT = 15451;

}