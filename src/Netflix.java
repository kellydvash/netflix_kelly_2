import java.util.ArrayList;
import java.util.Scanner;

public class Netflix {
    private ArrayList<Account> users;
    private ArrayList<TvSeries> tvSeries;
    private Scanner scanner = new Scanner(System.in);
    public Netflix() {
        users = new ArrayList<Account>();
        tvSeries = new ArrayList<TvSeries>();
    }
    public void add_user(String u_name , String pass) {
        login(u_name , pass);
    }


    public Account login(String u_name, String pass) {
        Account u = null;
        for (Account user : users) {
            if (user.getUserName().equals(u_name) && user.getPassword().equals(pass)) {
                u = user;
                u = new Account(user);

                break;
            }
        }
        return u;
    }

    public void add_tv_show() {
        String ep_name, brief;
        int day, month, year, choice;
        TvSeries tv1 = new TvSeries("How I Met Your Mother");
        tv1.add_episode("1" ," Lily meets an interesting person on the train to Farhampton, Marshall gets kicked off his flight to New York, Barney and Robin discover that they might be related, and Ted prepares to deliver a personal gift to Robin." ,23,2,2005);
        tv1.add_episode("2" ,"Marshall is forced to rent a car to get to New York, causing Lily to start drinking and accidentally reveal to Barney some bad news about his brother's marriage. " ,16,7,2007);
        tv1.add_episode("3" ,"Barney and Robin try to have sex before the elderly wedding guests arrive, Ted reveals a list to Lily of things to do before he leaves New York, and Marshall has problems traveling through Packer Country. " ,8,2,2008);
        tvSeries.add(tv1);
        TvSeries tv2 = new TvSeries("friends");
        tv2.add_episode("1" , "On Emma's first birthday, Ross and Rachel convince everyone to delay their plans so they can attend her party, however plans go awry when Emma's birthday cake is revealed.",15,6,2003);
        tv2.add_episode("2"  , "Rachel's sister Amy comes to visit and moves in with her and Joey. Phoebe constantly and accidentally ruins Mike's proposals. Joey struggles to write a letter of recommendation for Monica and Chandler's adoption agency." , 3,9,2003);
        tv2.add_episode("3" ,"Ross applies for a paleontology grant and finds out Charlie's ex-boyfriend reviews the applications. Monica and Rachel fight over who has to take Phoebe's ugly painting." , 18,3,2004);
        tvSeries.add(tv2);
        TvSeries tv3 = new TvSeries("The Big Bang Theory");
        tv3.add_episode("1" ,"Leonard and Penny give Sheldon and Amy a baffling wedding gift." ,13,12,2009);
        tv3.add_episode("2" ,"Amy doesn't have time to work with Sheldon on super asymmetry, so he goes to great lengths to ensure she's available. Koothrappali doesn't want Wolowitz to join him in hosting a show at the planetarium." , 25,3,2009);
        tv3.add_episode("3" , "Leonard is caught between a rock and a hard place when he's responsible for distributing extra grant money. Also, Bernadette turns the backyard playhouse into a hideaway from her husband and kids." , 1,9,2012);

        tvSeries.add(tv3);
    }

    public boolean checkUserName(String u_name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(u_name)) {
                return false;
            }
        }
        return true;
    }

    public void displayAllTvSeries() {

        for (TvSeries tvSeries : tvSeries) {
            System.out.println(tvSeries.getName());
        }
    }

    public void watchTvSeries(String showName, Account user) {
        TvSeries tS = null;
        for (TvSeries tvShow : tvSeries) {
            if (tvShow.getName().equals(showName)) {
                tS = tvShow;
                if (user.getSeriesWatched().containsKey(tvShow.getName())) {
                    ArrayList<String> a = user.getSeriesWatched().get(tvShow.getName());
                    System.out.printf("You watched episode ", a.get(a.size()-1));
                }
                tvShow.view_episodes();
            }
        }
        if (tS == null) {
            System.out.println("Show does not exist");
            return;
        }
        System.out.println("Please enter name of episode you want to watch");
        String ep_name = scanner.next();
        if (tS.check_ep_exist(ep_name)) {
            user.addToWatched(tS, ep_name);
        }
    }
}
