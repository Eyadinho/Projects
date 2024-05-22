import axios from 'axios';

const API_URL = 'https://api.coingecko.com/api/v3/coins/markets';
const CURRENCY = 'usd';

export const getCryptoData = async () => {
  try {
    const response = await axios.get(API_URL, {
      params: {
        vs_currency: CURRENCY,
        order: 'market_cap_desc',
        per_page: 10,
        page: 1,
        sparkline: false
      }
    });
    return response.data;
  } catch (error) {
    console.error('Error fetching cryptocurrency data:', error);
    throw error;
  }
};
