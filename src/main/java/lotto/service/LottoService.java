package lotto.service;

import lotto.domain.Lotto;

import java.util.List;

public class LottoService {
    private static final List<Integer> WINNING_PRIZES = List.of(0, 0, 0, 0, 5000, 50000, 1500000, 2000000000, 30000000);

    public List<Integer> sortLottoNumbersAscending(List<Integer> lottoNumber) {
        for (int i = 0; i < lottoNumber.size() - 1; i++) {
            for (int j = 0; j < lottoNumber.size() - i - 1; j++) {
                lottoNumber = swap(j, j + 1, lottoNumber);
            }
        }
        return lottoNumber;
    }

    private List<Integer> swap(int idx1, int idx2, List<Integer> arr) {
        if (arr.get(idx1) > arr.get(idx2)) {
            int tmp = arr.get(idx1);
            arr.set(idx1, arr.get(idx2));
            arr.set(idx2, tmp);
        }
        return arr;
    }

    public int calculateLottoQuantities(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public int matchingWinningNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer num : lottoNumbers) {
            if (winningNumbers.contains(num)) {
                count++;
            }
        }
        return count;
    }

    public int sumOfPrizes(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int sum = 0;
        for (Lotto lotto : lottos) {
            sum += lotto.getMatchingCount(winningNumbers, bonusNumber);
        }
        return sum;
    }
}
