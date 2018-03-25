# Java_Design_Patterns
适配器模式
------------
        适配器模式（Adapter Pattern）是作为两个不兼容的接口之间的桥梁。这种类型的设计模式属于结构型模式，它结合了两个独立接口的功能。
        
        这种模式涉及到一个单一的类，该类负责加入独立的或不兼容的接口功能。举个真实的例子，读卡器是作为内存卡和笔记本之间的适配器。您将内存卡插入读卡器，再将读卡器插入笔记本，这样就可以通过笔记本来读取内存卡。
        
        我们通过下面的实例来演示适配器模式的使用。其中，音频播放器设备只能播放 mp3 文件，通过使用一个更高级的音频播放器来播放 vlc 和 mp4 文件。
        
        介绍
        意图：将一个类的接口转换成客户希望的另外一个接口。适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
        
        主要解决：主要解决在软件系统中，常常要将一些"现存的对象"放到新的环境中，而新环境要求的接口是现对象不能满足的。
        
        优点： 
            1、可以让任何两个没有关联的类一起运行。 
            2、提高了类的复用。 
            3、增加了类的透明度。 
            4、灵活性好。
            
        缺点： 
            1、过多地使用适配器，会让系统非常零乱，不易整体进行把握。比如，明明看到调用的是 A 接口，其实内部被适配成了 B 接口的实现，一个系统如果太多出现这种情况，无异于一场灾难。因此如果不是很有必要，可以不使用适配器，而是直接对系统进行重构。 
            2、由于 JAVA 至多继承一个类，所以至多只能适配一个适配者类，而且目标类必须是抽象类。
            
        使用场景：有动机地修改一个正常运行的系统的接口，这时应该考虑使用适配器模式。
        
  
  
  ![适配器模式](https://github.com/lwx57280/Java_Design_Patterns/blob/master/AdapterPattern/img-folder/adapter_pattern_uml_diagram.jpg)
      
  
        **步骤 1**
        /**
         * 为媒体播放器和更高级的媒体播放器创建接口。
         */
        public interface MediaPlayer {
            public void play(String audioType,String fileName);
        }
        
        public interface AdvancedMediaPlayer {
        
            public void playVlc(String fileName);
        
            public void playMp4(String fileName);
        
        }
        
        **步骤 2**
        /**
         * 创建实现了 AdvancedMediaPlayer 接口的实体类。
         */
        public class VlcPlayer implements AdvancedMediaPlayer {
            @Override
            public void playVlc(String fileName) {
                System.out.println("Playing vlc file. Name: "+ fileName);
            }
        
            @Override
            public void playMp4(String fileName) {
                //什么也不做
            }
        }
        
        public class Mp4Player implements AdvancedMediaPlayer {
            @Override
            public void playVlc(String fileName) {
                //什么也不做
            }
        
            @Override
            public void playMp4(String fileName) {
                System.out.println("Playing mp4 file. Name: "+ fileName);
            }
        }
        
        **步骤 3**        
        /**
         * 创建实现了 MediaPlayer 接口的适配器类。
         */
        public class MediaAdapter implements MediaPlayer {
        
            AdvancedMediaPlayer advancedMediaPlayer;
        
            public MediaAdapter(String audioType) {
               if(audioType.equalsIgnoreCase("vlc")){
                   advancedMediaPlayer = new VlcPlayer();
               }else if(audioType.equalsIgnoreCase("mp4")){
                   advancedMediaPlayer = new Mp4Player();
               }
            }
        
            @Override
            public void play(String audioType, String fileName) {
                if(audioType.equalsIgnoreCase("vlc")){
                    advancedMediaPlayer.playVlc(fileName);
                }else if(audioType.equalsIgnoreCase("mp4")){
                    advancedMediaPlayer.playMp4(fileName);
                }
            }
        }
        
        **步骤 4**
        /**
         * 创建实现了 MediaPlayer 接口的实体类。
         */
        public class AudioPlayer implements MediaPlayer {
            MediaPlayer mediaPlayer;
        
            @Override
            public void play(String audioType, String fileName) {
                //播放 mp3 音乐文件的内置支持
                if(audioType.equalsIgnoreCase("mp3")){
                    System.out.println("Playing mp3 file. Name: "+ fileName);
                }
                //mediaAdapter 提供了播放其他文件格式的支持
                else if (audioType.equalsIgnoreCase("vlc")||audioType.equalsIgnoreCase("mp4")){
                    mediaPlayer = new MediaAdapter(audioType);
                    mediaPlayer.play(audioType,fileName);
                }else {
                    System.out.println("Invalid media. "+ audioType + " format not supported");
                }
            }
        }
        
        **步骤 5**
        
        /**
         * 使用 AudioPlayer 来播放不同类型的音频格式。
         */
        public class AdapterPatternDemo {
            public static void main(String[] args){
                AudioPlayer audioPlayer = new AudioPlayer();
                audioPlayer.play("mp3","beyond the horizon.mp3");
                audioPlayer.play("mp4","alone.mp4");
                audioPlayer.play("avi","mind me.avi");
            }
        }
