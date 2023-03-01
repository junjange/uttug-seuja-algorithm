def change(music):
    if 'A#' in music:
        music = music.replace('A#', 'a')
    if 'F#' in music:
        music = music.replace('F#', 'f')
    if 'C#' in music:
        music = music.replace('C#', 'c')
    if 'G#' in music:
        music = music.replace('G#', 'g')
    if 'D#' in music:
        music = music.replace('D#', 'd')
    return music

def solution(m, musicinfos):
    answer = ''
    time = 0

    for musics in musicinfos:
        music = musics.split(",")
        start = music[0].split(':') # 시작 시간
        end = music[1].split(':')  # 종료 시간
        current_time = (int(end[0])*60 + int(end[1])) - (int(start[0])*60 + int(start[1]))

        # 악보에 #이 붙은 음을 소문자로 변환
        changed = change(music[3])
        
        # 음악 길이
        a = len(changed)
        
        # 재생시간에 재생된 음
        b = changed * (current_time // a) + changed[:current_time%a]
        
        m = change(m)
        
        if m in b:            
            if answer:
                if time < current_time:
                    time = current_time
                    answer = music[2]
                
            else:
                answer = music[2]
                time = current_time
    
    if not answer:
        return "(None)"
    return answer
