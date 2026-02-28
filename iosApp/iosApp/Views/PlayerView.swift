import SwiftUI

struct PlayerView: View {
    @StateObject private var audioPlayer = IOSAudioPlayer()
    @State private var progress: Double = 0.5
    
    var body: some View {
        VStack(spacing: 30) {
            // Album Art (Imitando Material 3 con esquinas redondeadas)
            RoundedRectangle(cornerRadius: 32)
                .fill(Color.gray.opacity(0.3))
                .aspectRatio(1, contentMode: .fit)
                .padding(24)
                .overlay(
                    Image(systemName: "music.note")
                        .resizable()
                        .frame(width: 80, height: 80)
                        .foregroundColor(.gray)
                )
            
            // Título y Artista
            VStack(spacing: 8) {
                Text("Nombre de la Canción")
                    .font(.title)
                    .fontWeight(.bold)
                Text("Artista de PixelPlayer")
                    .font(.headline)
                    .foregroundColor(.secondary)
            }
            
            // Slider de Progreso
            VStack {
                Slider(value: $progress)
                    .accentColor(.purple) // Color similar a Material 3
                HStack {
                    Text("0:00")
                    Spacer()
                    Text("3:45")
                }
                .font(.caption)
                .foregroundColor(.secondary)
            }
            .padding(.horizontal, 24)
            
            // Controles de Reproducción
            HStack(spacing: 40) {
                Button(action: {}) {
                    Image(systemName: "shuffle")
                        .font(.title2)
                }
                
                Button(action: {}) {
                    Image(systemName: "backward.fill")
                        .font(.largeTitle)
                }
                
                Button(action: { audioPlayer.togglePlayPause() }) {
                    Image(systemName: audioPlayer.isPlaying ? "pause.circle.fill" : "play.circle.fill")
                        .resizable()
                        .frame(width: 80, height: 80)
                        .foregroundColor(.purple)
                }
                
                Button(action: {}) {
                    Image(systemName: "forward.fill")
                        .font(.largeTitle)
                }
                
                Button(action: {}) {
                    Image(systemName: "repeat")
                        .font(.title2)
                }
            }
            .foregroundColor(.primary)
            
            Spacer()
        }
        .padding()
        .background(Color(uiColor: .systemBackground))
    }
}

struct PlayerView_Previews: PreviewProvider {
    static var previews: some View {
        PlayerView()
    }
}
