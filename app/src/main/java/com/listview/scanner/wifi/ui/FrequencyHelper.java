package com.listview.scanner.wifi.ui;


public class FrequencyHelper {

    /*
    CHA LOWER   CENTER  UPPER
    NUM FREQ    FREQ    FREQ
    MHZ     MHZ     MHZ
          1 2 401   2 412   2 423
          2 2 404   2 417   2 428
          3 2 411   2 422   2 433
          4 2 416   2 427   2 438
          5 2 421   2 432   2 443
          6 2 426   2 437   2 448
          7 2 431   2 442   2 453
          8 2 436   2 447   2 458
          9 2 441   2 452   2 463
          10 2 451   2 457   2 468
          11 2 451   2 462   2 473
          12 2 456   2 467   2 478
          13 2 461   2 472   2 483
          14 2 473   2 484   2 495

    */

    public static String getChannel(int frequency)
    {
        switch (frequency) {
            case 2412:
                return "1";
            case 2417:
                return "2";
            case 2422:
                return "3";
            case 2427:
                return "4";
            case 2432:
                return "5";
            case 2437:
                return "6";
            case 2442:
                return "7";
            case 2447:
                return "8";
            case 2462:
                return "9";
            case 2467:
                return "10";
            case 2472:
                return "11";
            case 2484:
                return "12";

            case 5035:
                return "7";
            case 5040:
                return "8";
            case 5045:
                return "9";
            case 5055:
                return "11";
            case 5060:
                return "12";
            case 5080:
                return "16";
            case 5160:
                return "32";
            case 5170:
                return "34";
            case 5180:
                return "36";
            case 5190:
                return "38";
            case 5200:
                return "40";
            case 5210:
                return "42";

            case 5220:
                return "44";
            case 5230:
                return "46";
            case 5240:
                return "48";
            case 5250:
                return "50";
            case 5260:
                return "52";
            case 5270:
                return "54";
            case 5280:
                return "56";
            case 5290:
                return "58";
            case 5300:
                return "60";
            case 5310:
                return "62";
            case 5320:
                return "64";
            case 5340:
                return "68";

            case 5480:
                return "96";
            case 5500:
                return "100";
            case 5510:
                return "102";
            case 5520:
                return "104";
            case 5530:
                return "106";
            case 5540:
                return "108";
            case 5550:
                return "110";
            case 5560:
                return "112";
            case 5570:
                return "114";
            case 5580:
                return "116";
            case 5590:
                return "118";
            case 5600:
                return "120";

            case 5610:
                return "122";
            case 5620:
                return "124";
            case 5630:
                return "126";
            case 5640:
                return "128";
            case 5660:
                return "132";
            case 5670:
                return "134";
            case 5680:
                return "136";
            case 5690:
                return "138";
            case 5700:
                return "140";
            case 5710:
                return "142";
            case 5720:
                return "144";
            case 5745:
                return "149";

            case 5755:
                return "151";
            case 5765:
                return "153";
            case 5775:
                return "155";
            case 5785:
                return "157";
            case 5795:
                return "159";
            case 5805:
                return "161";
            case 5825:
                return "165";
            case 5845:
                return "169";
            case 5865:
                return "173";
            case 4915:
                return "183";
            case 4920:
                return "184";
            case 4925:
                return "185";

            case 4935:
                return "187";
            case 4940:
                return "188";
            case 4945:
                return "189";
            case 4960:
                return "192";
            case 4980:
                return "196";
            default:
                return "?";
        }
    }

    public static String getBandFromFrequency(int frequency)
    {
       if(frequency>=2401 && frequency <=2495)
           return "2.4 GHz";
       else if(frequency>=5030 && frequency <=5875)
           return "5.0 GHz";
       else if(frequency>=4910 && frequency <=4990)
           return "5.0 GHz";
       else
           return "?";
    }
}
