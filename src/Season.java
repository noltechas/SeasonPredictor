public class Season {

    public Season(Schedule schedule,int seasons){
        for(int j = 0; j < seasons; j++) {
            for (int i = 0; i < 14; i++) {
                schedule.playWeek(i);
            }
            //schedule.setChampionship();
            //schedule.playChampionship();
            schedule.recordResults();
        }
    }
}
