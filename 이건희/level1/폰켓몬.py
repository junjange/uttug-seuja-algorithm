def solution(nums):
    monster = list(set(nums))
    if len(monster) < len(nums) // 2:
        return len(monster)
    return len(nums) // 2
