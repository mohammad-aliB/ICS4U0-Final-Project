/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mohammad
 */
public class mapHeight {
    public int height(int lvl,int x){
        if(lvl==2){
            //add in ur cordinates
          int y =-16;
          if (x+y< 288) {
            return 1000;
          } else if (x+y < 320) {
            return 544;
        } else if (x+y < 352) {
            return 480;
        } else if (x+y < 678) {
            return 416;
        } else if (x+y < 806) {
          return 480;
         } else if (x+y < 934) {
          return 1000;
         } else if (x+y < 1094) {
          return 512;
         } else if (x+y < 1222) {
           return 1000;
         } else if (x+y < 1350) {
           return 544;
         }else if (x+y < 1568) {
           return 576;
         }else if (x+y < 1632) {
           return 608;
         }else if (x+y < 1760) {
           return 1000;
         }else if (x+y < 1920) {
           return 608;
         }else if (x+y < 2016) {
           return 576;
         }else if (x+y < 2176) {
           return 512;
         }else if (x+y < 2560) {
           return 448;
         }else if (x+y < 2720) {
           return 512;
         }else if (x+y < 2784) {
           return 544;
         }else if (x+y < 2912) {
           return 1000;
         }else if (x+y < 2972) {
           return 576;
         }else if (x+y < 3040) {
           return 544;
         }else if (x+y < 3328) {
           return 512;
         }else if (x+y < 3488) {
           return 544;
         }else if (x+y < 3616) {
           return 608;
         }else if (x+y < 3744) {
           return 1000;
         }else if (x+y < 3872) {
           return 640;
         }else if (x+y < 4224) {
           return 608;
         }else if (x+y < 4512) {
           return 576;
         }else if (x+y < 4768) {
           return 544;
         }else if (x+y < 5184) {
           return 512;
         }else if (x+y < 5344) {
           return 480;
         }else if (x+y < 5376) {
           return 512;
         }else if (x+y < 5504) {
           return 1000;
         }else if (x+y < 5920) {
           return 512;
         }else if (x+y < 6272) {
           return 544;
         }
        else {
            return 1000;
        }
      }
        else if(lvl==1){
          int y =-16;
          if (x+y< 384) {
            return 1000;
          } else if (x+y < 416) {
            return 610;
          } else if (x+y < 448) {
            return 546;
          } else if (x+y < 640) {
            return 514;
          } else if (x+y < 960) {
            return 546;
          } else if (x+y < 1152) {
            return 578;
          } else if (x+y < 1280) {
            return 1000;
          } else if (x+y < 1502) {
            return 610;
          } else if (x+y < 1696) {
            return 578;
          } else if (x+y < 1892) {
            return 546;
          } else if (x+y < 2176) {
            return 514;
          } else if (x+y < 2560) {
            return 482;
          } else if (x+y < 2720) {
            return 514;
          } else if (x+y < 3040) {
            return 546;
          } else if (x+y < 3327) {
            return 578;
          } else if (x+y < 3616) {
            return 610;
          } else if (x+y < 3744) {
            return 1000;
          } else if (x+y < 3872) {
            return 642;
          } else if (x+y < 4224) {
            return 610;
          } else if (x+y < 4512) {
            return 578;
          } else if (x+y < 4768) {
            return 546;   
          } else if (x+y < 5184) {
            return 514;
          } else if (x+y < 5568) {
            return 482;   
          } else if (x+y < 5920) {
            return 514;   
          } else if (x+y < 6400) {
            return 546;   
          }  
          else {
            return 1000;
          }
        }
        else if (lvl==3){
          int y =-16;
          if (x+y< 448) {
            return 1000;
          } else if (x+y < 512) {
            return 546;
          } else if (x+y < 544) {
            return 482;
          } else if (x+y < 576) {
            return 450;
          } else if (x+y < 768) {
            return 418;
          } else if (x+y < 864) {
            return 450;
          } else if (x+y < 960) {
            return 1000;
          } else if (x+y < 992) {
            return 482;
          } else if (x+y < 1024) {
            return 450;
          } else if (x+y < 1152) {
            return 1000;
          } else if (x+y < 1216) {
            return 450;
          } else if (x+y < 1344) {
            return 1000;
          } else if (x+y < 1408) {
            return 450;
          } else if (x+y < 1504) {
            return 418;
          } else if (x+y < 1600) {
            return 386;
          } else if (x+y < 1664) {
            return 450;
          } else if (x+y < 1792) {
            return 1000;
          } else if (x+y < 1824) {
            return 482;
          } else if (x+y < 1888) {
            return 450;
          } else if (x+y < 1984) {
            return 418;
          } else if (x+y < 2176) {
            return 386;
          } else if (x+y < 2432) {
            return 354;
          } else if (x+y < 2496) {
            return 386;
          } else if (x+y < 2592) {
            return 418;
          } else if (x+y < 2624) {
            return 450;
          } else if (x+y < 2688) {
            return 482;
          } else if (x+y < 2816) {
            return 1000;
          } else if (x+y < 2848) {
            return 514;            
          } else if (x+y < 2912) {
            return 482;
          } else if (x+y < 3040) {
            return 1000;
          } else if (x+y < 3072) {
            return 482;
          } else if (x+y < 3168) {
            return 450;
          } else if (x+y < 3296) {
            return 1000;
           } else if (x+y < 3328) {
            return 514;
           } else if (x+y < 3424) {
            return 482;
            } else if (x+y < 3488) {
            return 514;
            } else if (x+y < 3616) {
              return 1000;
            } else if (x+y < 3712) {
              return 546;
            } else if (x+y < 3872) {
              return 514;
            } else if (x+y < 4064) {
              return 482;
            } else if (x+y < 4224) {
              return 450;
            } else if (x+y < 4384) {
              return 482;
            } else if (x+y < 4512) {
              return 1000;
            } else if (x+y < 4544) {
              return 546;
            } else if (x+y < 4576) {
              return 482;
            } else if (x+y < 4608) {
              return 450;
            } else if (x+y < 4832) {
              return 386;
            } else if (x+y < 4864) {
              return 418;
            } else if (x+y < 4896) {
              return 482;
            } else if (x+y < 4928) {
              return 546;
            } else if (x+y < 5024) {
              return 1000;
            } else if (x+y < 5056) {
              return 514;
            } else if (x+y < 5120) {
              return 482;
            } else if (x+y < 5184) {
              return 1000;
            } else if (x+y < 5216) {
              return 514;
            } else if (x+y < 5312) {
              return 482;
            } else if (x+y < 5376) {
              return 514;
            } else if (x+y < 5440) {
              return 1000;
            } else if (x+y < 5504) {
              return 482;
            } else if (x+y < 6400) {
              return 450;
          }
          else {
            return 1000;
          }
          
        }
        else
          return 1000;
    }
  
}
