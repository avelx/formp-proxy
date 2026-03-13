/*
 * Copyright 2026 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.formpproxy.sql

import scala.util.Random

object DataGenerator {

  val fullNames: Seq[String] = Seq(
    "Russell Ortiz    ",
    "Nyomi Pham       ",
    "Anna Pope        ",
    "Gunnar Hutchinson",
    "Jamie Cannon     ",
    "Archie Corona    ",
    "Marianna Kim     ",
    "Roman Cox        ",
    "Sadie Howell     ",
    "Bradley McDonald ",
    "Daisy Pittman    ",
    "Valentino Steele ",
    "Rylie Walker     ",
    "Luke Dougherty   ",
    "Alisson Moran    ",
    "Tate Page        ",
    "Cataleya Salgado ",
    "Trace Dejesus    ",
    "Julissa Diaz     ",
    "Nathan Leonard   ",
    "Demi Beltran     ",
    "Ricky Friedman   ",
    "Aspyn Lozano     ",
    "Boone Johnston   ",
    "Laila Acevedo    ",
    "Dakari McKay     ",
    "Leanna Carter    ",
    "Maverick Hines   ",
    "Poppy Morrison   ",
    "Maximus Keller   ",
    "Logan Larson     ",
    "Rafael Yoder     ",
    "Emerie McDowell  ",
    "Lachlan Carpenter",
    "Lilly Boyer      ",
    "Zeke Morrow      ",
    "Reyna Copeland   ",
    "Axton McBride    ",
    "Kelsey Ware      ",
    "Tadeo Bradshaw   ",
    "Berkley Hebert   ",
    "Guillermo Randall",
    "Kyro Higgins     ",
    "Leighton Villa   ",
    "Clay Schneider   ",
    "Delaney Shannon  ",
    "Eliel Hood       ",
    "Briana Russo     ",
    "Jamie Sanders    ",
    "Everleigh Thomas ",
    "Logan McDowell   ",
    "Rayna Tucker     ",
    "Ivan Kramer      ",
    "Hanna Barrett    ",
    "Angelo Liu       ",
    "Kate Lambert     ",
    "Mario Herring    ",
    "Denver Stanley   ",
    "Manuel Donaldson ",
    "Natasha Webster  ",
    "Shawn Barker     ",
    "Remington Lindsey",
    "Jayson Crosby    ",
    "Keily McCoy      ",
    "Jett Walls       ",
    "Reuben Rush      ",
    "Maleah Newman    ",
    "Anderson Stewart ",
    "Maya Walter      ",
    "Lochlan Wade     ",
    "Evie Holmes      ",
    "King Beard       ",
    "Ezra Huffman     ",
    "Chris Benson     ",
    "Collins Madden   ",
    "Everest Hanna    ",
    "Cynthia Eaton    ",
    "Leighton Abbott  ",
    "Melany Ortega    ",
    "Kobe McDonald    ",
    "Daisy Roy        ",
    "Marcelo Orozco   ",
    "Renata Brennan   ",
    "Curtis Ali       ",
    "Zelda McGuire    ",
    "Casey Yates      ",
    "Charley Hansen   ",
    "Charlie Lang     ",
    "Amirah Roberts   ",
    "Josiah Scott     ",
    "Aurora Le        ",
    "Damien Walton    ",
    "Scarlet Berger   ",
    "Byron Sullivan   ",
    "Melanie Mack     ",
    "Esteban Russell  ",
    "Raelynn Meyers   ",
    "Julien Nielsen   ",
    "Vienna Love      ",
    "Jeffrey Yu       ",
    "Navy Dalton      "
  )

  val addresses = List(
    "12 High Street, Reading, RG1 1EY",
    "45 Victoria Road, Manchester, M14 6AQ",
    "7 Station Road, Cambridge, CB1 2JB",
    "22 London Road, Brighton, BN1 4JA",
    "98 Church Lane, Birmingham, B20 2HJ",
    "31 Queens Road, Bristol, BS8 1QE",
    "14 Park Avenue, Leeds, LS8 2JJ",
    "56 The Drive, Ilford, IG1 3HT",
    "27 Castle Street, Edinburgh, EH2 3DN",
    "83 West Street, Sheffield, S1 4GB",
    "19 North Street, Exeter, EX4 3QS",
    "64 Mill Lane, London, NW6 1NJ",
    "5 Bridge Street, Cardiff, CF10 2EE",
    "42 York Road, Northampton, NN1 5QH",
    "11 Albert Road, Glasgow, G42 8RL",
    "37 King Street, Nottingham, NG1 2AY",
    "25 Oxford Road, Oxford, OX4 2EN",
    "76 Broadway, Peterborough, PE1 1SY",
    "13 Manor Way, Croydon, CR0 5RR",
    "50 Hillside, Liverpool, L25 5NZ",
    "9 Grove Road, Sutton, SM1 1BB",
    "21 South View, Newcastle upon Tyne, NE6 5UP",
    "68 Green Lane, Derby, DE1 1RP",
    "48 New Road, Portsmouth, PO2 7RL",
    "33 Lower Street, Bath, BA1 1EB",
    "17 Spring Gardens, London, SW1A 2HB",
    "59 Market Place, Warwick, CV34 4SA",
    "10 East Way, Southampton, SO15 2DT",
    "88 Long Lane, Hillingdon, UB10 0FE",
    "23 Boundary Road, Norwich, NR6 5JA",
    "71 Priory Road, Hull, HU5 5RX",
    "4 Canal Street, Perth, PH2 8HZ",
    "92 Forest Road, Loughborough, LE11 3NR",
    "15 Garden Street, York, YO31 7RP",
    "60 Wood Street, London, EC2V 7AN",
    "34 Silver Street, Durham, DH1 3RD",
    "18 Highfield Road, Blackpool, FY4 2JA",
    "52 Chapel Lane, Wigan, WN3 4AF",
    "77 Wellington Road, Stockport, SK4 1AA",
    "29 Brook Street, Chester, CH1 3DY",
    "41 Grange Road, Darlington, DL1 5NP",
    "66 Western Road, Hove, BN3 1JD",
    "12 Church Street, Inverness, IV1 1ED",
    "89 Bold Street, Liverpool, L1 4HF",
    "24 George Street, Plymouth, PL1 1RJ",
    "55 The Parade, Watford, WD17 1LU",
    "30 High Cross Street, Leicester, LE1 4NN",
    "95 Broad Street, Aberdeen, AB10 1AQ",
    "2 Sun Street, Canterbury, CT1 2JH",
    "47 Castle Gate, Newark, NG24 1AZ"
  )

  def getNextSureName: String = {
    val index = Random.nextInt(fullNames.length - 1)
    fullNames(index).trim
  }

  def getNextFullAddress: String = {
    val index = Random.nextInt(addresses.length - 1)
    addresses(index).trim
  }

}
