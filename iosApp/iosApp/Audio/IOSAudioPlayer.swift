import Foundation
import AVFoundation

class IOSAudioPlayer: NSObject, ObservableObject {
    private var player: AVPlayer?
    @Published var isPlaying = false
    @Published var currentTime: Double = 0
    @Published var duration: Double = 0
    
    func play(url: URL) {
        let playerItem = AVPlayerItem(url: url)
        player = AVPlayer(playerItem: playerItem)
        player?.play()
        isPlaying = true
        
        // Configuración para que suene en segundo plano
        try? AVAudioSession.sharedInstance().setCategory(.playback, mode: .default)
        try? AVAudioSession.sharedInstance().setActive(true)
    }
    
    func togglePlayPause() {
        if isPlaying {
            player?.pause()
        } else {
            player?.play()
        }
        isPlaying.toggle()
    }
    
    func seek(to time: Double) {
        let targetTime = CMTime(seconds: time, preferredTimescale: 600)
        player?.seek(to: targetTime)
    }
}
