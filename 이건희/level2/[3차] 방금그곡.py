def solution(m, musicinfos):
    result = [0, '(None)']
    m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a")

    for i in musicinfos:
        start_time, end_time, title, melody = i.split(",")
        start_hour, start_min = map(int, start_time.split(':'))
        end_hour, end_min = map(int, end_time.split(':'))

        time = (end_hour * 60 + end_min) - (start_hour * 60 + start_min)
        melody = melody.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a")

        if m in (melody * (time // len(melody) + 1))[:time] and result[0] < time:
            result = [time, title]

    return result[1]
