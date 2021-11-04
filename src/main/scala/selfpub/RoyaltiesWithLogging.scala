package selfpub

import org.slf4j.LoggerFactory

object RoyaltiesWithLogging:
  
  import java.time.YearMonth

  private val logger = LoggerFactory.getLogger("RoyaltiesCalculation")

  def royaltiesForMonth(sales: List[BigDecimal], month: YearMonth): BigDecimal =
    val royaltyRate = BigDecimal(0.75)
    logger.info("royalty rate = {}", royaltyRate)
    val totalRevenue = sales.sum
    logger.info("total revenue = {}", totalRevenue)
    val result = totalRevenue * royaltyRate
    logger.info("royalties for {}, total revenue * royalty rate = {} * {} = {}", 
      month, totalRevenue, royaltyRate, result)
    result

