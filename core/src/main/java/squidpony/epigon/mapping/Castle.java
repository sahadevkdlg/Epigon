package squidpony.epigon.mapping;

import squidpony.squidmath.GreasedRegion;

/**
 * Holds a set of structures for creating a castle.
 *
 * @author Eben Howard
 */
public class Castle {
    /* Castle notes from real castles
    Average thickness of stone wall: 2m but can be up to 15m

    Standard motte and baily area: 0.12 square km

    Approximate largest stone keeps: 31m x 31m

    Motte and Bailey style usually had one of each but sometimes up to two
    Motte is a raised mound with a building on it for final defense
    Mottes were 5-15m high (just the earthen part, not including the building on top)
    Bailey is the larger, lower open area surrounded by a wall or pallisagde
    A drawbridge connected the bailey to the motte

    Shell Keeps were essentially a Bailey only with a stone wall instead of wooden pallisades

    Pleshey Castle (Motte & Bailey style, 1 each)
      - bailey is a kidney shape 190m x 90m
      - base of motte is 90m diameter
      - top of motte is 28m
      - motte is 15m high
      - had wood pallisades and buildings

    Malbork Castle
      - total area covered, including grounds outside walls: 12 square km

    Borl Castle (in Croatia)
      - walls thickness up to 12m

    Chepstow Castle (in Wales)
      - walls thickness is 6m
    
     */
    
    public EpiMap[] buildZone;
    public EpiMap groundLevel;
    public int sky; // how high you can go
    public int width;
    public int height;
    public int mapEdging = 2; // space between the edge of the map and the generation area
    
    GreasedRegion region,
        moat,
        moatBank,
        insideMoat,
        outerWall,
        holes,
        courtyard,
        keepWall,
        insideKeep,
        garden,
        pond,
        pondBank;
    
    public Castle(EpiMap[] buildZone){
        this.buildZone = buildZone;
        sky = buildZone.length;
        groundLevel = buildZone[sky - 1];
        width = buildZone[0].width;
        height = buildZone[1].height;
        
                region = new GreasedRegion(width, height);
        region.allOn();
        for (int x = 0; x < mapEdging; x++) {
            for (int y = 0; y < height; y++) {
                region.set(false, x, y);
                region.set(false, width - 1 - x, y);
            }
        }
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < mapEdging; y++) {
                region.set(false, x, y);
                region.set(false, x, height - 1 - y);
            }
        }

        moat = region.copy();
    }
}
