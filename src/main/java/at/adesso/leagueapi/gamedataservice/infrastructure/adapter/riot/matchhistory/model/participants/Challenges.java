package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.participants;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Challenges {

    @JsonProperty("12AssistStreakCount")
    public Integer _12AssistStreakCount;
    public Integer abilityUses;
    public Integer acesBefore15Minutes;
    public Integer alliedJungleMonsterKills;
    public Integer baronBuffGoldAdvantageOverThreshold;
    public Integer baronTakedowns;
    public Integer blastConeOppositeOpponentCount;
    public Integer bountyGold;
    public Integer buffsStolen;
    public Integer completeSupportQuestInTime;
    public Double controlWardTimeCoverageInRiverOrEnemyHalf;
    public Integer controlWardsPlaced;
    public Double damagePerMinute;
    public Double damageTakenOnTeamPercentage;
    public Integer dancedWithRiftHerald;
    public Integer deathsByEnemyChamps;
    public Integer dodgeSkillShotsSmallWindow;
    public Integer doubleAces;
    public Integer dragonTakedowns;
    public Double earliestBaron;
    public Double earliestDragonTakedown;
    public Integer earlyLaningPhaseGoldExpAdvantage;
    public Double effectiveHealAndShielding;
    public Integer elderDragonKillsWithOpposingSoul;
    public Integer elderDragonMultikills;
    public Integer enemyChampionImmobilizations;
    public Integer enemyJungleMonsterKills;
    public Integer epicMonsterKillsNearEnemyJungler;
    public Integer epicMonsterKillsWithin30SecondsOfSpawn;
    public Integer epicMonsterSteals;
    public Integer epicMonsterStolenWithoutSmite;
    public Double firstTurretKilled;
    public Integer flawlessAces;
    public Integer fullTeamTakedown;
    public Double gameLength;
    public Integer getTakedownsInAllLanesEarlyJungleAsLaner;
    public Double goldPerMinute;
    public Integer hadOpenNexus;
    public Integer immobilizeAndKillWithAlly;
    public Integer initialBuffCount;
    public Integer initialCrabCount;
    public Integer jungleCsBefore10Minutes;
    public Integer junglerTakedownsNearDamagedEpicMonster;
    public Integer kTurretsDestroyedBeforePlatesFall;
    public Double kda;
    public Integer killAfterHiddenWithAlly;
    public Double killParticipation;
    public Integer killedChampTookFullTeamDamageSurvived;
    public Integer killingSprees;
    public Integer killsNearEnemyTurret;
    public Integer killsOnOtherLanesEarlyJungleAsLaner;
    public Integer killsOnRecentlyHealedByAramPack;
    public Integer killsUnderOwnTurret;
    public Integer killsWithHelpFromEpicMonster;
    public Integer knockEnemyIntoTeamAndKill;
    public Integer landSkillShotsEarlyGame;
    public Integer laneMinionsFirst10Minutes;
    public Integer laningPhaseGoldExpAdvantage;
    public Integer legendaryCount;
    public Integer lostAnInhibitor;
    public Integer maxCsAdvantageOnLaneOpponent;
    public Integer maxKillDeficit;
    public Integer maxLevelLeadLaneOpponent;
    public Integer mejaisFullStackInTime;
    public Integer moreEnemyJungleThanOpponent;
    public Integer multiKillOneSpell;
    public Integer multiTurretRiftHeraldCount;
    public Integer multikills;
    public Integer multikillsAfterAggressiveFlash;
    public Integer mythicItemUsed;
    public Integer outerTurretExecutesBefore10Minutes;
    public Integer outnumberedKills;
    public Integer outnumberedNexusKill;
    public Integer perfectDragonSoulsTaken;
    public Integer perfectGame;
    public Integer pickKillWithAlly;
    public Integer playedChampSelectPosition;
    public Integer poroExplosions;
    public Integer quickCleanse;
    public Integer quickFirstTurret;
    public Integer quickSoloKills;
    public Integer riftHeraldTakedowns;
    public Integer saveAllyFromDeath;
    public Integer scuttleCrabKills;
    public Double shortestTimeToAceFromFirstTakedown;
    public Integer skillshotsDodged;
    public Integer skillshotsHit;
    public Integer snowballsHit;
    public Integer soloBaronKills;
    public Integer soloKills;
    public Integer stealthWardsPlaced;
    public Integer survivedSingleDigitHpCount;
    public Integer survivedThreeImmobilizesInFight;
    public Integer takedownOnFirstTurret;
    public Integer takedowns;
    public Integer takedownsAfterGainingLevelAdvantage;
    public Integer takedownsBeforeJungleMinionSpawn;
    public Integer takedownsFirstXMinutes;
    public Integer takedownsInAlcove;
    public Integer takedownsInEnemyFountain;
    public Integer teamBaronKills;
    public Double teamDamagePercentage;
    public Integer teamElderDragonKills;
    public Integer teamRiftHeraldKills;
    public Integer threeWardsOneSweeperCount;
    public Integer tookLargeDamageSurvived;
    public Integer turretPlatesTaken;
    public Integer turretTakedowns;
    public Integer turretsTakenWithRiftHerald;
    public Integer twentyMinionsIn3SecondsCount;
    public Integer unseenRecalls;
    public Double visionScoreAdvantageLaneOpponent;
    public Double visionScorePerMinute;
    public Integer wardTakedowns;
    public Integer wardTakedownsBefore20M;
    public Integer wardsGuarded;
    public Integer junglerKillsEarlyJungle;
    public Integer killsOnLanersEarlyJungleAsJungler;
    public Double fastestLegendary;
    public Integer soloTurretsLategame;
    public Integer teleportTakedowns;
    public Integer highestChampionDamage;
    public Integer highestCrowdControlScore;
    public Integer fasterSupportQuestCompletion;
    public Integer highestWardKills;

}