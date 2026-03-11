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

package demo
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends Tables {
  val profile: slick.jdbc.JdbcProfile = slick.jdbc.OracleProfile
}

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this
  * late.)
  */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  import slick.collection.heterogeneous._
  import slick.collection.heterogeneous.syntax._
  // NOTE: GetResult mappers for plain SQL are only generated for
  // tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(
    Agent.schema,
    CompanyDetails.schema,
    CompanyDetailsBackup.schema,
    DbaLogging.schema,
    DisadvantagedPostcodes.schema,
    DmsSchemaInfo.schema,
    GovtalkMessageData.schema,
    GovtalkMessageLog.schema,
    GovtalkStatus.schema,
    GovtalkStatusBackup.schema,
    Land.schema,
    LandBackup.schema,
    Lease.schema,
    LeaseBackup.schema,
    PreventMessageAudit.schema,
    Purchaser.schema,
    PurchaserBackup.schema,
    Residency.schema,
    Return.schema,
    ReturnAgent.schema,
    ReturnAgentBackup.schema,
    ReturnBackup.schema,
    SdltOrganisation.schema,
    Submission.schema,
    SubmissionBackup.schema,
    SubmissionErrorDetail.schema,
    SubmissionErrorDetailBackup.schema,
    TaxCalculation.schema,
    TaxCalculationBackup.schema,
    Transaction.schema,
    TransactionBackup.schema,
    TreatmentGroup.schema,
    Vendor.schema,
    VendorBackup.schema
  ).reduceLeft(_ ++ _)

  /** Entity class storing rows of table Agent
    * @param agentId
    *   Database column AGENT_ID SqlType(NUMBER), PrimaryKey
    * @param storn
    *   Database column STORN SqlType(VARCHAR2), Length(10,true)
    * @param name
    *   Database column NAME SqlType(VARCHAR2), Length(500,true)
    * @param houseNumber
    *   Database column HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param address1
    *   Database column ADDRESS_1 SqlType(VARCHAR2), Length(500,true)
    * @param address2
    *   Database column ADDRESS_2 SqlType(VARCHAR2), Length(500,true)
    * @param address3
    *   Database column ADDRESS_3 SqlType(VARCHAR2), Length(500,true)
    * @param address4
    *   Database column ADDRESS_4 SqlType(VARCHAR2), Length(500,true)
    * @param postcode
    *   Database column POSTCODE SqlType(VARCHAR2), Length(500,true)
    * @param phone
    *   Database column PHONE SqlType(VARCHAR2), Length(500,true)
    * @param email
    *   Database column EMAIL SqlType(VARCHAR2), Length(500,true)
    * @param dxAddress
    *   Database column DX_ADDRESS SqlType(VARCHAR2), Length(500,true)
    * @param agentResourceRef
    *   Database column AGENT_RESOURCE_REF SqlType(NUMBER)
    * @param version
    *   Database column VERSION SqlType(NUMBER)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    */
  case class AgentRow(
    agentId: scala.math.BigDecimal,
    storn: String,
    name: Option[String],
    houseNumber: Option[String],
    address1: Option[String],
    address2: Option[String],
    address3: Option[String],
    address4: Option[String],
    postcode: Option[String],
    phone: Option[String],
    email: Option[String],
    dxAddress: Option[String],
    agentResourceRef: Option[scala.math.BigDecimal],
    version: Option[scala.math.BigDecimal],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp
  )

  /** GetResult implicit for fetching AgentRow objects using plain SQL queries */
  implicit def GetResultAgentRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[String],
    e2: GR[Option[String]],
    e3: GR[Option[scala.math.BigDecimal]],
    e4: GR[java.sql.Timestamp]
  ): GR[AgentRow] = GR { prs =>
    import prs._
    (AgentRow.apply _).tupled(
      (
        <<[scala.math.BigDecimal],
        <<[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<[java.sql.Timestamp],
        <<[java.sql.Timestamp]
      )
    )
  }

  /** Table description of table AGENT. Objects of this class serve as prototypes for rows in queries. */
  class Agent(_tableTag: Tag) extends profile.api.Table[AgentRow](_tableTag, Some("SDLT_FILE_DATA"), "AGENT") {
    def * = (
      (
        agentId,
        storn,
        name,
        houseNumber,
        address1,
        address2,
        address3,
        address4,
        postcode,
        phone,
        email,
        dxAddress,
        agentResourceRef,
        version,
        lMigrated,
        createDate,
        lastUpdateDate
      )
    ).mapTo[AgentRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(agentId),
        Rep.Some(storn),
        name,
        houseNumber,
        address1,
        address2,
        address3,
        address4,
        postcode,
        phone,
        email,
        dxAddress,
        agentResourceRef,
        version,
        lMigrated,
        Rep.Some(createDate),
        Rep.Some(lastUpdateDate)
      )
    ).shaped.<>(
      { r =>
        import r._;
        _1.map(_ =>
          (AgentRow.apply _)
            .tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16.get, _17.get))
        )
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column AGENT_ID SqlType(NUMBER), PrimaryKey */
    val agentId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("AGENT_ID", O.PrimaryKey)

    /** Database column STORN SqlType(VARCHAR2), Length(10,true) */
    val storn: Rep[String] = column[String]("STORN", O.Length(10, varying = true))

    /** Database column NAME SqlType(VARCHAR2), Length(500,true) */
    val name: Rep[Option[String]] = column[Option[String]]("NAME", O.Length(500, varying = true))

    /** Database column HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val houseNumber: Rep[Option[String]] = column[Option[String]]("HOUSE_NUMBER", O.Length(500, varying = true))

    /** Database column ADDRESS_1 SqlType(VARCHAR2), Length(500,true) */
    val address1: Rep[Option[String]] = column[Option[String]]("ADDRESS_1", O.Length(500, varying = true))

    /** Database column ADDRESS_2 SqlType(VARCHAR2), Length(500,true) */
    val address2: Rep[Option[String]] = column[Option[String]]("ADDRESS_2", O.Length(500, varying = true))

    /** Database column ADDRESS_3 SqlType(VARCHAR2), Length(500,true) */
    val address3: Rep[Option[String]] = column[Option[String]]("ADDRESS_3", O.Length(500, varying = true))

    /** Database column ADDRESS_4 SqlType(VARCHAR2), Length(500,true) */
    val address4: Rep[Option[String]] = column[Option[String]]("ADDRESS_4", O.Length(500, varying = true))

    /** Database column POSTCODE SqlType(VARCHAR2), Length(500,true) */
    val postcode: Rep[Option[String]] = column[Option[String]]("POSTCODE", O.Length(500, varying = true))

    /** Database column PHONE SqlType(VARCHAR2), Length(500,true) */
    val phone: Rep[Option[String]] = column[Option[String]]("PHONE", O.Length(500, varying = true))

    /** Database column EMAIL SqlType(VARCHAR2), Length(500,true) */
    val email: Rep[Option[String]] = column[Option[String]]("EMAIL", O.Length(500, varying = true))

    /** Database column DX_ADDRESS SqlType(VARCHAR2), Length(500,true) */
    val dxAddress: Rep[Option[String]] = column[Option[String]]("DX_ADDRESS", O.Length(500, varying = true))

    /** Database column AGENT_RESOURCE_REF SqlType(NUMBER) */
    val agentResourceRef: Rep[Option[scala.math.BigDecimal]] =
      column[Option[scala.math.BigDecimal]]("AGENT_RESOURCE_REF")

    /** Database column VERSION SqlType(NUMBER) */
    val version: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("VERSION")

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")

    /** Foreign key referencing SdltOrganisation (database name AGENT_SDLT_USER_FK) */
    lazy val sdltOrganisationFk = foreignKey("AGENT_SDLT_USER_FK", storn, SdltOrganisation)(
      r => r.storn,
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )
  }

  /** Collection-like TableQuery object for table Agent */
  lazy val Agent = new TableQuery(tag => new Agent(tag))

  /** Entity class storing rows of table CompanyDetails
    * @param companyDetailsId
    *   Database column COMPANY_DETAILS_ID SqlType(NUMBER), PrimaryKey
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param purchaserId
    *   Database column PURCHASER_ID SqlType(NUMBER)
    * @param utr
    *   Database column UTR SqlType(VARCHAR2), Length(500,true)
    * @param vatReference
    *   Database column VAT_REFERENCE SqlType(VARCHAR2), Length(500,true)
    * @param companyTypeBank
    *   Database column COMPANY_TYPE_BANK SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeBuilder
    *   Database column COMPANY_TYPE_BUILDER SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeBuildsoc
    *   Database column COMPANY_TYPE_BUILDSOC SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeCentgov
    *   Database column COMPANY_TYPE_CENTGOV SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeIndividual
    *   Database column COMPANY_TYPE_INDIVIDUAL SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeInsurance
    *   Database column COMPANY_TYPE_INSURANCE SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeLocalauth
    *   Database column COMPANY_TYPE_LOCALAUTH SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeOthercharity
    *   Database column COMPANY_TYPE_OTHERCHARITY SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeOthercompany
    *   Database column COMPANY_TYPE_OTHERCOMPANY SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeOtherfinancial
    *   Database column COMPANY_TYPE_OTHERFINANCIAL SqlType(VARCHAR2), Length(3,true)
    * @param companyTypePartnership
    *   Database column COMPANY_TYPE_PARTNERSHIP SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeProperty
    *   Database column COMPANY_TYPE_PROPERTY SqlType(VARCHAR2), Length(3,true)
    * @param companyTypePubliccorp
    *   Database column COMPANY_TYPE_PUBLICCORP SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeSoletrader
    *   Database column COMPANY_TYPE_SOLETRADER SqlType(VARCHAR2), Length(3,true)
    * @param companyTypePensionfund
    *   Database column COMPANY_TYPE_PENSIONFUND SqlType(VARCHAR2), Length(3,true)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    */
  case class CompanyDetailsRow(
    companyDetailsId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    purchaserId: Option[scala.math.BigDecimal],
    utr: Option[String],
    vatReference: Option[String],
    companyTypeBank: Option[String],
    companyTypeBuilder: Option[String],
    companyTypeBuildsoc: Option[String],
    companyTypeCentgov: Option[String],
    companyTypeIndividual: Option[String],
    companyTypeInsurance: Option[String],
    companyTypeLocalauth: Option[String],
    companyTypeOthercharity: Option[String],
    companyTypeOthercompany: Option[String],
    companyTypeOtherfinancial: Option[String],
    companyTypePartnership: Option[String],
    companyTypeProperty: Option[String],
    companyTypePubliccorp: Option[String],
    companyTypeSoletrader: Option[String],
    companyTypePensionfund: Option[String],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp
  )

  /** GetResult implicit for fetching CompanyDetailsRow objects using plain SQL queries */
  implicit def GetResultCompanyDetailsRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[scala.math.BigDecimal]],
    e2: GR[Option[String]],
    e3: GR[java.sql.Timestamp]
  ): GR[CompanyDetailsRow] = GR { prs =>
    import prs._
    CompanyDetailsRow(
      <<[scala.math.BigDecimal],
      <<[scala.math.BigDecimal],
      <<?[scala.math.BigDecimal],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[scala.math.BigDecimal],
      <<[java.sql.Timestamp],
      <<[java.sql.Timestamp]
    )
  }

  /** Table description of table COMPANY_DETAILS. Objects of this class serve as prototypes for rows in queries. */
  class CompanyDetails(_tableTag: Tag)
      extends profile.api.Table[CompanyDetailsRow](_tableTag, Some("SDLT_FILE_DATA"), "COMPANY_DETAILS") {
    def * =
      (companyDetailsId :: returnId :: purchaserId :: utr :: vatReference :: companyTypeBank :: companyTypeBuilder :: companyTypeBuildsoc :: companyTypeCentgov :: companyTypeIndividual :: companyTypeInsurance :: companyTypeLocalauth :: companyTypeOthercharity :: companyTypeOthercompany :: companyTypeOtherfinancial :: companyTypePartnership :: companyTypeProperty :: companyTypePubliccorp :: companyTypeSoletrader :: companyTypePensionfund :: lMigrated :: createDate :: lastUpdateDate :: HNil)
        .mapTo[CompanyDetailsRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(companyDetailsId) :: Rep.Some(
      returnId
    ) :: purchaserId :: utr :: vatReference :: companyTypeBank :: companyTypeBuilder :: companyTypeBuildsoc :: companyTypeCentgov :: companyTypeIndividual :: companyTypeInsurance :: companyTypeLocalauth :: companyTypeOthercharity :: companyTypeOthercompany :: companyTypeOtherfinancial :: companyTypePartnership :: companyTypeProperty :: companyTypePubliccorp :: companyTypeSoletrader :: companyTypePensionfund :: lMigrated :: Rep
      .Some(createDate) :: Rep.Some(lastUpdateDate) :: HNil).shaped.<>(
      r =>
        CompanyDetailsRow(
          r.productElement(0).asInstanceOf[Option[scala.math.BigDecimal]].get,
          r.productElement(1).asInstanceOf[Option[scala.math.BigDecimal]].get,
          r.productElement(2).asInstanceOf[Option[scala.math.BigDecimal]],
          r.productElement(3).asInstanceOf[Option[String]],
          r.productElement(4).asInstanceOf[Option[String]],
          r.productElement(5).asInstanceOf[Option[String]],
          r.productElement(6).asInstanceOf[Option[String]],
          r.productElement(7).asInstanceOf[Option[String]],
          r.productElement(8).asInstanceOf[Option[String]],
          r.productElement(9).asInstanceOf[Option[String]],
          r.productElement(10).asInstanceOf[Option[String]],
          r.productElement(11).asInstanceOf[Option[String]],
          r.productElement(12).asInstanceOf[Option[String]],
          r.productElement(13).asInstanceOf[Option[String]],
          r.productElement(14).asInstanceOf[Option[String]],
          r.productElement(15).asInstanceOf[Option[String]],
          r.productElement(16).asInstanceOf[Option[String]],
          r.productElement(17).asInstanceOf[Option[String]],
          r.productElement(18).asInstanceOf[Option[String]],
          r.productElement(19).asInstanceOf[Option[String]],
          r.productElement(20).asInstanceOf[Option[scala.math.BigDecimal]],
          r.productElement(21).asInstanceOf[Option[java.sql.Timestamp]].get,
          r.productElement(22).asInstanceOf[Option[java.sql.Timestamp]].get
        ),
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column COMPANY_DETAILS_ID SqlType(NUMBER), PrimaryKey */
    val companyDetailsId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("COMPANY_DETAILS_ID", O.PrimaryKey)

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column PURCHASER_ID SqlType(NUMBER) */
    val purchaserId: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("PURCHASER_ID")

    /** Database column UTR SqlType(VARCHAR2), Length(500,true) */
    val utr: Rep[Option[String]] = column[Option[String]]("UTR", O.Length(500, varying = true))

    /** Database column VAT_REFERENCE SqlType(VARCHAR2), Length(500,true) */
    val vatReference: Rep[Option[String]] = column[Option[String]]("VAT_REFERENCE", O.Length(500, varying = true))

    /** Database column COMPANY_TYPE_BANK SqlType(VARCHAR2), Length(3,true) */
    val companyTypeBank: Rep[Option[String]] = column[Option[String]]("COMPANY_TYPE_BANK", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_BUILDER SqlType(VARCHAR2), Length(3,true) */
    val companyTypeBuilder: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_BUILDER", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_BUILDSOC SqlType(VARCHAR2), Length(3,true) */
    val companyTypeBuildsoc: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_BUILDSOC", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_CENTGOV SqlType(VARCHAR2), Length(3,true) */
    val companyTypeCentgov: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_CENTGOV", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_INDIVIDUAL SqlType(VARCHAR2), Length(3,true) */
    val companyTypeIndividual: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_INDIVIDUAL", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_INSURANCE SqlType(VARCHAR2), Length(3,true) */
    val companyTypeInsurance: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_INSURANCE", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_LOCALAUTH SqlType(VARCHAR2), Length(3,true) */
    val companyTypeLocalauth: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_LOCALAUTH", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_OTHERCHARITY SqlType(VARCHAR2), Length(3,true) */
    val companyTypeOthercharity: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_OTHERCHARITY", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_OTHERCOMPANY SqlType(VARCHAR2), Length(3,true) */
    val companyTypeOthercompany: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_OTHERCOMPANY", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_OTHERFINANCIAL SqlType(VARCHAR2), Length(3,true) */
    val companyTypeOtherfinancial: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_OTHERFINANCIAL", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_PARTNERSHIP SqlType(VARCHAR2), Length(3,true) */
    val companyTypePartnership: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_PARTNERSHIP", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_PROPERTY SqlType(VARCHAR2), Length(3,true) */
    val companyTypeProperty: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_PROPERTY", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_PUBLICCORP SqlType(VARCHAR2), Length(3,true) */
    val companyTypePubliccorp: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_PUBLICCORP", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_SOLETRADER SqlType(VARCHAR2), Length(3,true) */
    val companyTypeSoletrader: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_SOLETRADER", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_PENSIONFUND SqlType(VARCHAR2), Length(3,true) */
    val companyTypePensionfund: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_PENSIONFUND", O.Length(3, varying = true))

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")

    /** Foreign key referencing Purchaser (database name COMPDETAILS_PURCHASERID_FCK) */
    lazy val purchaserFk = foreignKey("COMPDETAILS_PURCHASERID_FCK", purchaserId :: HNil, Purchaser)(
      r => Rep.Some(r.purchaserId) :: HNil,
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )

    /** Foreign key referencing Return (database name COMPDETAILS_RETURNID_FCK) */
    lazy val returnFk = foreignKey("COMPDETAILS_RETURNID_FCK", returnId :: HNil, Return)(
      r => r.returnId :: HNil,
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )

    /** Uniqueness Index over (returnId) (database name COMPDETAILS_RETURNID_IDX) */
    val index1 = index("COMPDETAILS_RETURNID_IDX", returnId :: HNil, unique = true)
  }

  /** Collection-like TableQuery object for table CompanyDetails */
  lazy val CompanyDetails = new TableQuery(tag => new CompanyDetails(tag))

  /** Entity class storing rows of table CompanyDetailsBackup
    * @param companyDetailsId
    *   Database column COMPANY_DETAILS_ID SqlType(NUMBER)
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param purchaserId
    *   Database column PURCHASER_ID SqlType(NUMBER)
    * @param utr
    *   Database column UTR SqlType(VARCHAR2), Length(500,true)
    * @param vatReference
    *   Database column VAT_REFERENCE SqlType(VARCHAR2), Length(500,true)
    * @param companyTypeBank
    *   Database column COMPANY_TYPE_BANK SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeBuilder
    *   Database column COMPANY_TYPE_BUILDER SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeBuildsoc
    *   Database column COMPANY_TYPE_BUILDSOC SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeCentgov
    *   Database column COMPANY_TYPE_CENTGOV SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeIndividual
    *   Database column COMPANY_TYPE_INDIVIDUAL SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeInsurance
    *   Database column COMPANY_TYPE_INSURANCE SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeLocalauth
    *   Database column COMPANY_TYPE_LOCALAUTH SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeOthercharity
    *   Database column COMPANY_TYPE_OTHERCHARITY SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeOthercompany
    *   Database column COMPANY_TYPE_OTHERCOMPANY SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeOtherfinancial
    *   Database column COMPANY_TYPE_OTHERFINANCIAL SqlType(VARCHAR2), Length(3,true)
    * @param companyTypePartnership
    *   Database column COMPANY_TYPE_PARTNERSHIP SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeProperty
    *   Database column COMPANY_TYPE_PROPERTY SqlType(VARCHAR2), Length(3,true)
    * @param companyTypePubliccorp
    *   Database column COMPANY_TYPE_PUBLICCORP SqlType(VARCHAR2), Length(3,true)
    * @param companyTypeSoletrader
    *   Database column COMPANY_TYPE_SOLETRADER SqlType(VARCHAR2), Length(3,true)
    * @param companyTypePensionfund
    *   Database column COMPANY_TYPE_PENSIONFUND SqlType(VARCHAR2), Length(3,true)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    */
  case class CompanyDetailsBackupRow(
    companyDetailsId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    purchaserId: Option[scala.math.BigDecimal],
    utr: Option[String],
    vatReference: Option[String],
    companyTypeBank: Option[String],
    companyTypeBuilder: Option[String],
    companyTypeBuildsoc: Option[String],
    companyTypeCentgov: Option[String],
    companyTypeIndividual: Option[String],
    companyTypeInsurance: Option[String],
    companyTypeLocalauth: Option[String],
    companyTypeOthercharity: Option[String],
    companyTypeOthercompany: Option[String],
    companyTypeOtherfinancial: Option[String],
    companyTypePartnership: Option[String],
    companyTypeProperty: Option[String],
    companyTypePubliccorp: Option[String],
    companyTypeSoletrader: Option[String],
    companyTypePensionfund: Option[String],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp
  )

  /** GetResult implicit for fetching CompanyDetailsBackupRow objects using plain SQL queries */
  implicit def GetResultCompanyDetailsBackupRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[scala.math.BigDecimal]],
    e2: GR[Option[String]],
    e3: GR[java.sql.Timestamp]
  ): GR[CompanyDetailsBackupRow] = GR { prs =>
    import prs._
    CompanyDetailsBackupRow(
      <<[scala.math.BigDecimal],
      <<[scala.math.BigDecimal],
      <<?[scala.math.BigDecimal],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[scala.math.BigDecimal],
      <<[java.sql.Timestamp],
      <<[java.sql.Timestamp]
    )
  }

  /** Table description of table COMPANY_DETAILS_BACKUP. Objects of this class serve as prototypes for rows in queries.
    */
  class CompanyDetailsBackup(_tableTag: Tag)
      extends profile.api.Table[CompanyDetailsBackupRow](_tableTag, Some("SDLT_FILE_DATA"), "COMPANY_DETAILS_BACKUP") {
    def * =
      (companyDetailsId :: returnId :: purchaserId :: utr :: vatReference :: companyTypeBank :: companyTypeBuilder :: companyTypeBuildsoc :: companyTypeCentgov :: companyTypeIndividual :: companyTypeInsurance :: companyTypeLocalauth :: companyTypeOthercharity :: companyTypeOthercompany :: companyTypeOtherfinancial :: companyTypePartnership :: companyTypeProperty :: companyTypePubliccorp :: companyTypeSoletrader :: companyTypePensionfund :: lMigrated :: createDate :: lastUpdateDate :: HNil)
        .mapTo[CompanyDetailsBackupRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(companyDetailsId) :: Rep.Some(
      returnId
    ) :: purchaserId :: utr :: vatReference :: companyTypeBank :: companyTypeBuilder :: companyTypeBuildsoc :: companyTypeCentgov :: companyTypeIndividual :: companyTypeInsurance :: companyTypeLocalauth :: companyTypeOthercharity :: companyTypeOthercompany :: companyTypeOtherfinancial :: companyTypePartnership :: companyTypeProperty :: companyTypePubliccorp :: companyTypeSoletrader :: companyTypePensionfund :: lMigrated :: Rep
      .Some(createDate) :: Rep.Some(lastUpdateDate) :: HNil).shaped.<>(
      r =>
        CompanyDetailsBackupRow(
          r.productElement(0).asInstanceOf[Option[scala.math.BigDecimal]].get,
          r.productElement(1).asInstanceOf[Option[scala.math.BigDecimal]].get,
          r.productElement(2).asInstanceOf[Option[scala.math.BigDecimal]],
          r.productElement(3).asInstanceOf[Option[String]],
          r.productElement(4).asInstanceOf[Option[String]],
          r.productElement(5).asInstanceOf[Option[String]],
          r.productElement(6).asInstanceOf[Option[String]],
          r.productElement(7).asInstanceOf[Option[String]],
          r.productElement(8).asInstanceOf[Option[String]],
          r.productElement(9).asInstanceOf[Option[String]],
          r.productElement(10).asInstanceOf[Option[String]],
          r.productElement(11).asInstanceOf[Option[String]],
          r.productElement(12).asInstanceOf[Option[String]],
          r.productElement(13).asInstanceOf[Option[String]],
          r.productElement(14).asInstanceOf[Option[String]],
          r.productElement(15).asInstanceOf[Option[String]],
          r.productElement(16).asInstanceOf[Option[String]],
          r.productElement(17).asInstanceOf[Option[String]],
          r.productElement(18).asInstanceOf[Option[String]],
          r.productElement(19).asInstanceOf[Option[String]],
          r.productElement(20).asInstanceOf[Option[scala.math.BigDecimal]],
          r.productElement(21).asInstanceOf[Option[java.sql.Timestamp]].get,
          r.productElement(22).asInstanceOf[Option[java.sql.Timestamp]].get
        ),
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column COMPANY_DETAILS_ID SqlType(NUMBER) */
    val companyDetailsId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("COMPANY_DETAILS_ID")

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column PURCHASER_ID SqlType(NUMBER) */
    val purchaserId: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("PURCHASER_ID")

    /** Database column UTR SqlType(VARCHAR2), Length(500,true) */
    val utr: Rep[Option[String]] = column[Option[String]]("UTR", O.Length(500, varying = true))

    /** Database column VAT_REFERENCE SqlType(VARCHAR2), Length(500,true) */
    val vatReference: Rep[Option[String]] = column[Option[String]]("VAT_REFERENCE", O.Length(500, varying = true))

    /** Database column COMPANY_TYPE_BANK SqlType(VARCHAR2), Length(3,true) */
    val companyTypeBank: Rep[Option[String]] = column[Option[String]]("COMPANY_TYPE_BANK", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_BUILDER SqlType(VARCHAR2), Length(3,true) */
    val companyTypeBuilder: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_BUILDER", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_BUILDSOC SqlType(VARCHAR2), Length(3,true) */
    val companyTypeBuildsoc: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_BUILDSOC", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_CENTGOV SqlType(VARCHAR2), Length(3,true) */
    val companyTypeCentgov: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_CENTGOV", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_INDIVIDUAL SqlType(VARCHAR2), Length(3,true) */
    val companyTypeIndividual: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_INDIVIDUAL", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_INSURANCE SqlType(VARCHAR2), Length(3,true) */
    val companyTypeInsurance: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_INSURANCE", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_LOCALAUTH SqlType(VARCHAR2), Length(3,true) */
    val companyTypeLocalauth: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_LOCALAUTH", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_OTHERCHARITY SqlType(VARCHAR2), Length(3,true) */
    val companyTypeOthercharity: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_OTHERCHARITY", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_OTHERCOMPANY SqlType(VARCHAR2), Length(3,true) */
    val companyTypeOthercompany: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_OTHERCOMPANY", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_OTHERFINANCIAL SqlType(VARCHAR2), Length(3,true) */
    val companyTypeOtherfinancial: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_OTHERFINANCIAL", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_PARTNERSHIP SqlType(VARCHAR2), Length(3,true) */
    val companyTypePartnership: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_PARTNERSHIP", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_PROPERTY SqlType(VARCHAR2), Length(3,true) */
    val companyTypeProperty: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_PROPERTY", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_PUBLICCORP SqlType(VARCHAR2), Length(3,true) */
    val companyTypePubliccorp: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_PUBLICCORP", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_SOLETRADER SqlType(VARCHAR2), Length(3,true) */
    val companyTypeSoletrader: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_SOLETRADER", O.Length(3, varying = true))

    /** Database column COMPANY_TYPE_PENSIONFUND SqlType(VARCHAR2), Length(3,true) */
    val companyTypePensionfund: Rep[Option[String]] =
      column[Option[String]]("COMPANY_TYPE_PENSIONFUND", O.Length(3, varying = true))

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")
  }

  /** Collection-like TableQuery object for table CompanyDetailsBackup */
  lazy val CompanyDetailsBackup = new TableQuery(tag => new CompanyDetailsBackup(tag))

  /** Entity class storing rows of table DbaLogging
    * @param procedureName
    *   Database column PROCEDURE_NAME SqlType(VARCHAR2), Length(50,true)
    * @param credentialId
    *   Database column CREDENTIAL_ID SqlType(VARCHAR2), Length(38,true)
    */
  case class DbaLoggingRow(procedureName: String, credentialId: String)

  /** GetResult implicit for fetching DbaLoggingRow objects using plain SQL queries */
  implicit def GetResultDbaLoggingRow(implicit e0: GR[String]): GR[DbaLoggingRow] = GR { prs =>
    import prs._
    (DbaLoggingRow.apply _).tupled((<<[String], <<[String]))
  }

  /** Table description of table DBA_LOGGING. Objects of this class serve as prototypes for rows in queries. */
  class DbaLogging(_tableTag: Tag)
      extends profile.api.Table[DbaLoggingRow](_tableTag, Some("SDLT_FILE_DATA"), "DBA_LOGGING") {
    def * = ((procedureName, credentialId)).mapTo[DbaLoggingRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(procedureName), Rep.Some(credentialId))).shaped.<>(
      { r =>
        import r._; _1.map(_ => (DbaLoggingRow.apply _).tupled((_1.get, _2.get)))
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column PROCEDURE_NAME SqlType(VARCHAR2), Length(50,true) */
    val procedureName: Rep[String] = column[String]("PROCEDURE_NAME", O.Length(50, varying = true))

    /** Database column CREDENTIAL_ID SqlType(VARCHAR2), Length(38,true) */
    val credentialId: Rep[String] = column[String]("CREDENTIAL_ID", O.Length(38, varying = true))
  }

  /** Collection-like TableQuery object for table DbaLogging */
  lazy val DbaLogging = new TableQuery(tag => new DbaLogging(tag))

  /** Entity class storing rows of table DisadvantagedPostcodes
    * @param postcode
    *   Database column POSTCODE SqlType(VARCHAR2), PrimaryKey, Length(8,true)
    */
  case class DisadvantagedPostcodesRow(postcode: String)

  /** GetResult implicit for fetching DisadvantagedPostcodesRow objects using plain SQL queries */
  implicit def GetResultDisadvantagedPostcodesRow(implicit e0: GR[String]): GR[DisadvantagedPostcodesRow] = GR { prs =>
    import prs._
    DisadvantagedPostcodesRow(<<[String])
  }

  /** Table description of table DISADVANTAGED_POSTCODES. Objects of this class serve as prototypes for rows in queries.
    */
  class DisadvantagedPostcodes(_tableTag: Tag)
      extends profile.api.Table[DisadvantagedPostcodesRow](
        _tableTag,
        Some("SDLT_FILE_DATA"),
        "DISADVANTAGED_POSTCODES"
      ) {
    def * = postcode.mapTo[DisadvantagedPostcodesRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = Rep
      .Some(postcode)
      .shaped
      .<>(
        r => r.map(_ => DisadvantagedPostcodesRow(r.get)),
        (_: Any) => throw new Exception("Inserting into ? projection not supported.")
      )

    /** Database column POSTCODE SqlType(VARCHAR2), PrimaryKey, Length(8,true) */
    val postcode: Rep[String] = column[String]("POSTCODE", O.PrimaryKey, O.Length(8, varying = true))
  }

  /** Collection-like TableQuery object for table DisadvantagedPostcodes */
  lazy val DisadvantagedPostcodes = new TableQuery(tag => new DisadvantagedPostcodes(tag))

  /** Entity class storing rows of table DmsSchemaInfo
    * @param schemaNameX
    *   Database column SCHEMA_NAME SqlType(VARCHAR2), Length(30,true)
    * @param releaseName
    *   Database column RELEASE_NAME SqlType(VARCHAR2), Length(30,true)
    * @param schemaVersion
    *   Database column SCHEMA_VERSION SqlType(VARCHAR2), Length(30,true)
    * @param dateOfChange
    *   Database column DATE_OF_CHANGE SqlType(DATE)
    * @param notes
    *   Database column NOTES SqlType(VARCHAR2), Length(4000,true)
    */
  case class DmsSchemaInfoRow(
    schemaNameX: String,
    releaseName: String,
    schemaVersion: String,
    dateOfChange: java.sql.Timestamp,
    notes: Option[String]
  )

  /** GetResult implicit for fetching DmsSchemaInfoRow objects using plain SQL queries */
  implicit def GetResultDmsSchemaInfoRow(implicit
    e0: GR[String],
    e1: GR[java.sql.Timestamp],
    e2: GR[Option[String]]
  ): GR[DmsSchemaInfoRow] = GR { prs =>
    import prs._
    (DmsSchemaInfoRow.apply _).tupled((<<[String], <<[String], <<[String], <<[java.sql.Timestamp], <<?[String]))
  }

  /** Table description of table DMS_SCHEMA_INFO. Objects of this class serve as prototypes for rows in queries. NOTE:
    * The following names collided with Scala method names and were disambiguated: schemaName
    */
  class DmsSchemaInfo(_tableTag: Tag)
      extends profile.api.Table[DmsSchemaInfoRow](_tableTag, Some("SDLT_FILE_DATA"), "DMS_SCHEMA_INFO") {
    def * = ((schemaNameX, releaseName, schemaVersion, dateOfChange, notes)).mapTo[DmsSchemaInfoRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? =
      ((Rep.Some(schemaNameX), Rep.Some(releaseName), Rep.Some(schemaVersion), Rep.Some(dateOfChange), notes)).shaped
        .<>(
          { r =>
            import r._; _1.map(_ => (DmsSchemaInfoRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5)))
          },
          (_: Any) => throw new Exception("Inserting into ? projection not supported.")
        )

    /** Database column SCHEMA_NAME SqlType(VARCHAR2), Length(30,true) NOTE: The name was disambiguated because it
      * collided with Slick's method Table#schemaName.
      */
    val schemaNameX: Rep[String] = column[String]("SCHEMA_NAME", O.Length(30, varying = true))

    /** Database column RELEASE_NAME SqlType(VARCHAR2), Length(30,true) */
    val releaseName: Rep[String] = column[String]("RELEASE_NAME", O.Length(30, varying = true))

    /** Database column SCHEMA_VERSION SqlType(VARCHAR2), Length(30,true) */
    val schemaVersion: Rep[String] = column[String]("SCHEMA_VERSION", O.Length(30, varying = true))

    /** Database column DATE_OF_CHANGE SqlType(DATE) */
    val dateOfChange: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("DATE_OF_CHANGE")

    /** Database column NOTES SqlType(VARCHAR2), Length(4000,true) */
    val notes: Rep[Option[String]] = column[Option[String]]("NOTES", O.Length(4000, varying = true))
  }

  /** Collection-like TableQuery object for table DmsSchemaInfo */
  lazy val DmsSchemaInfo = new TableQuery(tag => new DmsSchemaInfo(tag))

  /** Entity class storing rows of table GovtalkMessageData
    * @param messageId
    *   Database column MESSAGE_ID SqlType(NUMBER)
    * @param messageData
    *   Database column MESSAGE_DATA SqlType(CLOB)
    */
  case class GovtalkMessageDataRow(messageId: Option[scala.math.BigDecimal], messageData: Option[java.sql.Clob])

  /** GetResult implicit for fetching GovtalkMessageDataRow objects using plain SQL queries */
  implicit def GetResultGovtalkMessageDataRow(implicit
    e0: GR[Option[scala.math.BigDecimal]],
    e1: GR[Option[java.sql.Clob]]
  ): GR[GovtalkMessageDataRow] = GR { prs =>
    import prs._
    (GovtalkMessageDataRow.apply _).tupled((<<?[scala.math.BigDecimal], <<?[java.sql.Clob]))
  }

  /** Table description of table GOVTALK_MESSAGE_DATA. Objects of this class serve as prototypes for rows in queries. */
  class GovtalkMessageData(_tableTag: Tag)
      extends profile.api.Table[GovtalkMessageDataRow](_tableTag, Some("SDLT_FILE_DATA"), "GOVTALK_MESSAGE_DATA") {
    def * = ((messageId, messageData)).mapTo[GovtalkMessageDataRow]

    /** Database column MESSAGE_ID SqlType(NUMBER) */
    val messageId: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("MESSAGE_ID")

    /** Database column MESSAGE_DATA SqlType(CLOB) */
    val messageData: Rep[Option[java.sql.Clob]] = column[Option[java.sql.Clob]]("MESSAGE_DATA")

    /** Uniqueness Index over (messageId) (database name SYS_IL0000095312C00002$$) */
    val index1 = index("SYS_IL0000095312C00002$$", messageId, unique = true)
  }

  /** Collection-like TableQuery object for table GovtalkMessageData */
  lazy val GovtalkMessageData = new TableQuery(tag => new GovtalkMessageData(tag))

  /** Entity class storing rows of table GovtalkMessageLog
    * @param messageId
    *   Database column MESSAGE_ID SqlType(NUMBER)
    * @param userIdentifier
    *   Database column USER_IDENTIFIER SqlType(VARCHAR2), Length(255,true)
    * @param formresultid
    *   Database column FORMRESULTID SqlType(VARCHAR2), Length(32,true)
    * @param messageType
    *   Database column MESSAGE_TYPE SqlType(VARCHAR2), Length(255,true)
    * @param saveDate
    *   Database column SAVE_DATE SqlType(DATE)
    */
  case class GovtalkMessageLogRow(
    messageId: Option[scala.math.BigDecimal],
    userIdentifier: Option[String],
    formresultid: Option[String],
    messageType: Option[String],
    saveDate: Option[java.sql.Timestamp]
  )

  /** GetResult implicit for fetching GovtalkMessageLogRow objects using plain SQL queries */
  implicit def GetResultGovtalkMessageLogRow(implicit
    e0: GR[Option[scala.math.BigDecimal]],
    e1: GR[Option[String]],
    e2: GR[Option[java.sql.Timestamp]]
  ): GR[GovtalkMessageLogRow] = GR { prs =>
    import prs._
    (GovtalkMessageLogRow.apply _).tupled(
      (<<?[scala.math.BigDecimal], <<?[String], <<?[String], <<?[String], <<?[java.sql.Timestamp])
    )
  }

  /** Table description of table GOVTALK_MESSAGE_LOG. Objects of this class serve as prototypes for rows in queries. */
  class GovtalkMessageLog(_tableTag: Tag)
      extends profile.api.Table[GovtalkMessageLogRow](_tableTag, Some("SDLT_FILE_DATA"), "GOVTALK_MESSAGE_LOG") {
    def * = ((messageId, userIdentifier, formresultid, messageType, saveDate)).mapTo[GovtalkMessageLogRow]

    /** Database column MESSAGE_ID SqlType(NUMBER) */
    val messageId: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("MESSAGE_ID")

    /** Database column USER_IDENTIFIER SqlType(VARCHAR2), Length(255,true) */
    val userIdentifier: Rep[Option[String]] = column[Option[String]]("USER_IDENTIFIER", O.Length(255, varying = true))

    /** Database column FORMRESULTID SqlType(VARCHAR2), Length(32,true) */
    val formresultid: Rep[Option[String]] = column[Option[String]]("FORMRESULTID", O.Length(32, varying = true))

    /** Database column MESSAGE_TYPE SqlType(VARCHAR2), Length(255,true) */
    val messageType: Rep[Option[String]] = column[Option[String]]("MESSAGE_TYPE", O.Length(255, varying = true))

    /** Database column SAVE_DATE SqlType(DATE) */
    val saveDate: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("SAVE_DATE")
  }

  /** Collection-like TableQuery object for table GovtalkMessageLog */
  lazy val GovtalkMessageLog = new TableQuery(tag => new GovtalkMessageLog(tag))

  /** Entity class storing rows of table GovtalkStatus
    * @param userIdentifier
    *   Database column USER_IDENTIFIER SqlType(VARCHAR2), Length(255,true)
    * @param formresultid
    *   Database column FORMRESULTID SqlType(VARCHAR2), PrimaryKey, Length(32,true)
    * @param correlationid
    *   Database column CORRELATIONID SqlType(VARCHAR2), Length(32,true)
    * @param formLock
    *   Database column FORM_LOCK SqlType(CHAR)
    * @param createTimestamp
    *   Database column CREATE_TIMESTAMP SqlType(DATE)
    * @param endstateTimestamp
    *   Database column ENDSTATE_TIMESTAMP SqlType(DATE)
    * @param lastMesgTimestamp
    *   Database column LAST_MESG_TIMESTAMP SqlType(DATE)
    * @param numPolls
    *   Database column NUM_POLLS SqlType(NUMBER)
    * @param pollInterval
    *   Database column POLL_INTERVAL SqlType(NUMBER)
    * @param protocolStatus
    *   Database column PROTOCOL_STATUS SqlType(VARCHAR2), Length(16,true)
    * @param gatewayurl
    *   Database column GATEWAYURL SqlType(VARCHAR2), Length(255,true)
    */
  case class GovtalkStatusRow(
    userIdentifier: String,
    formresultid: String,
    correlationid: String,
    formLock: Char,
    createTimestamp: Option[java.sql.Timestamp],
    endstateTimestamp: Option[java.sql.Timestamp],
    lastMesgTimestamp: java.sql.Timestamp,
    numPolls: scala.math.BigDecimal,
    pollInterval: scala.math.BigDecimal,
    protocolStatus: String,
    gatewayurl: String
  )

  /** GetResult implicit for fetching GovtalkStatusRow objects using plain SQL queries */
  implicit def GetResultGovtalkStatusRow(implicit
    e0: GR[String],
    e1: GR[Char],
    e2: GR[Option[java.sql.Timestamp]],
    e3: GR[java.sql.Timestamp],
    e4: GR[scala.math.BigDecimal]
  ): GR[GovtalkStatusRow] = GR { prs =>
    import prs._
    (GovtalkStatusRow.apply _).tupled(
      (
        <<[String],
        <<[String],
        <<[String],
        <<[Char],
        <<?[java.sql.Timestamp],
        <<?[java.sql.Timestamp],
        <<[java.sql.Timestamp],
        <<[scala.math.BigDecimal],
        <<[scala.math.BigDecimal],
        <<[String],
        <<[String]
      )
    )
  }

  /** Table description of table GOVTALK_STATUS. Objects of this class serve as prototypes for rows in queries. */
  class GovtalkStatus(_tableTag: Tag)
      extends profile.api.Table[GovtalkStatusRow](_tableTag, Some("SDLT_FILE_DATA"), "GOVTALK_STATUS") {
    def * = (
      (
        userIdentifier,
        formresultid,
        correlationid,
        formLock,
        createTimestamp,
        endstateTimestamp,
        lastMesgTimestamp,
        numPolls,
        pollInterval,
        protocolStatus,
        gatewayurl
      )
    ).mapTo[GovtalkStatusRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(userIdentifier),
        Rep.Some(formresultid),
        Rep.Some(correlationid),
        Rep.Some(formLock),
        createTimestamp,
        endstateTimestamp,
        Rep.Some(lastMesgTimestamp),
        Rep.Some(numPolls),
        Rep.Some(pollInterval),
        Rep.Some(protocolStatus),
        Rep.Some(gatewayurl)
      )
    ).shaped.<>(
      { r =>
        import r._;
        _1.map(_ =>
          (GovtalkStatusRow.apply _)
            .tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7.get, _8.get, _9.get, _10.get, _11.get))
        )
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column USER_IDENTIFIER SqlType(VARCHAR2), Length(255,true) */
    val userIdentifier: Rep[String] = column[String]("USER_IDENTIFIER", O.Length(255, varying = true))

    /** Database column FORMRESULTID SqlType(VARCHAR2), PrimaryKey, Length(32,true) */
    val formresultid: Rep[String] = column[String]("FORMRESULTID", O.PrimaryKey, O.Length(32, varying = true))

    /** Database column CORRELATIONID SqlType(VARCHAR2), Length(32,true) */
    val correlationid: Rep[String] = column[String]("CORRELATIONID", O.Length(32, varying = true))

    /** Database column FORM_LOCK SqlType(CHAR) */
    val formLock: Rep[Char] = column[Char]("FORM_LOCK")

    /** Database column CREATE_TIMESTAMP SqlType(DATE) */
    val createTimestamp: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("CREATE_TIMESTAMP")

    /** Database column ENDSTATE_TIMESTAMP SqlType(DATE) */
    val endstateTimestamp: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("ENDSTATE_TIMESTAMP")

    /** Database column LAST_MESG_TIMESTAMP SqlType(DATE) */
    val lastMesgTimestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_MESG_TIMESTAMP")

    /** Database column NUM_POLLS SqlType(NUMBER) */
    val numPolls: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("NUM_POLLS")

    /** Database column POLL_INTERVAL SqlType(NUMBER) */
    val pollInterval: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("POLL_INTERVAL")

    /** Database column PROTOCOL_STATUS SqlType(VARCHAR2), Length(16,true) */
    val protocolStatus: Rep[String] = column[String]("PROTOCOL_STATUS", O.Length(16, varying = true))

    /** Database column GATEWAYURL SqlType(VARCHAR2), Length(255,true) */
    val gatewayurl: Rep[String] = column[String]("GATEWAYURL", O.Length(255, varying = true))

    /** Index over (userIdentifier) (database name GOVSTATUS_USERID_IDX) */
    val index1 = index("GOVSTATUS_USERID_IDX", userIdentifier)
  }

  /** Collection-like TableQuery object for table GovtalkStatus */
  lazy val GovtalkStatus = new TableQuery(tag => new GovtalkStatus(tag))

  /** Entity class storing rows of table GovtalkStatusBackup
    * @param userIdentifier
    *   Database column USER_IDENTIFIER SqlType(VARCHAR2), Length(255,true)
    * @param formresultid
    *   Database column FORMRESULTID SqlType(VARCHAR2), Length(32,true)
    * @param correlationid
    *   Database column CORRELATIONID SqlType(VARCHAR2), Length(32,true)
    * @param formLock
    *   Database column FORM_LOCK SqlType(CHAR)
    * @param createTimestamp
    *   Database column CREATE_TIMESTAMP SqlType(DATE)
    * @param endstateTimestamp
    *   Database column ENDSTATE_TIMESTAMP SqlType(DATE)
    * @param lastMesgTimestamp
    *   Database column LAST_MESG_TIMESTAMP SqlType(DATE)
    * @param numPolls
    *   Database column NUM_POLLS SqlType(NUMBER)
    * @param pollInterval
    *   Database column POLL_INTERVAL SqlType(NUMBER)
    * @param protocolStatus
    *   Database column PROTOCOL_STATUS SqlType(VARCHAR2), Length(16,true)
    * @param gatewayurl
    *   Database column GATEWAYURL SqlType(VARCHAR2), Length(255,true)
    */
  case class GovtalkStatusBackupRow(
    userIdentifier: String,
    formresultid: String,
    correlationid: String,
    formLock: Char,
    createTimestamp: Option[java.sql.Timestamp],
    endstateTimestamp: Option[java.sql.Timestamp],
    lastMesgTimestamp: java.sql.Timestamp,
    numPolls: scala.math.BigDecimal,
    pollInterval: scala.math.BigDecimal,
    protocolStatus: String,
    gatewayurl: String
  )

  /** GetResult implicit for fetching GovtalkStatusBackupRow objects using plain SQL queries */
  implicit def GetResultGovtalkStatusBackupRow(implicit
    e0: GR[String],
    e1: GR[Char],
    e2: GR[Option[java.sql.Timestamp]],
    e3: GR[java.sql.Timestamp],
    e4: GR[scala.math.BigDecimal]
  ): GR[GovtalkStatusBackupRow] = GR { prs =>
    import prs._
    (GovtalkStatusBackupRow.apply _).tupled(
      (
        <<[String],
        <<[String],
        <<[String],
        <<[Char],
        <<?[java.sql.Timestamp],
        <<?[java.sql.Timestamp],
        <<[java.sql.Timestamp],
        <<[scala.math.BigDecimal],
        <<[scala.math.BigDecimal],
        <<[String],
        <<[String]
      )
    )
  }

  /** Table description of table GOVTALK_STATUS_BACKUP. Objects of this class serve as prototypes for rows in queries.
    */
  class GovtalkStatusBackup(_tableTag: Tag)
      extends profile.api.Table[GovtalkStatusBackupRow](_tableTag, Some("SDLT_FILE_DATA"), "GOVTALK_STATUS_BACKUP") {
    def * = (
      (
        userIdentifier,
        formresultid,
        correlationid,
        formLock,
        createTimestamp,
        endstateTimestamp,
        lastMesgTimestamp,
        numPolls,
        pollInterval,
        protocolStatus,
        gatewayurl
      )
    ).mapTo[GovtalkStatusBackupRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(userIdentifier),
        Rep.Some(formresultid),
        Rep.Some(correlationid),
        Rep.Some(formLock),
        createTimestamp,
        endstateTimestamp,
        Rep.Some(lastMesgTimestamp),
        Rep.Some(numPolls),
        Rep.Some(pollInterval),
        Rep.Some(protocolStatus),
        Rep.Some(gatewayurl)
      )
    ).shaped.<>(
      { r =>
        import r._;
        _1.map(_ =>
          (GovtalkStatusBackupRow.apply _)
            .tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7.get, _8.get, _9.get, _10.get, _11.get))
        )
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column USER_IDENTIFIER SqlType(VARCHAR2), Length(255,true) */
    val userIdentifier: Rep[String] = column[String]("USER_IDENTIFIER", O.Length(255, varying = true))

    /** Database column FORMRESULTID SqlType(VARCHAR2), Length(32,true) */
    val formresultid: Rep[String] = column[String]("FORMRESULTID", O.Length(32, varying = true))

    /** Database column CORRELATIONID SqlType(VARCHAR2), Length(32,true) */
    val correlationid: Rep[String] = column[String]("CORRELATIONID", O.Length(32, varying = true))

    /** Database column FORM_LOCK SqlType(CHAR) */
    val formLock: Rep[Char] = column[Char]("FORM_LOCK")

    /** Database column CREATE_TIMESTAMP SqlType(DATE) */
    val createTimestamp: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("CREATE_TIMESTAMP")

    /** Database column ENDSTATE_TIMESTAMP SqlType(DATE) */
    val endstateTimestamp: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("ENDSTATE_TIMESTAMP")

    /** Database column LAST_MESG_TIMESTAMP SqlType(DATE) */
    val lastMesgTimestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_MESG_TIMESTAMP")

    /** Database column NUM_POLLS SqlType(NUMBER) */
    val numPolls: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("NUM_POLLS")

    /** Database column POLL_INTERVAL SqlType(NUMBER) */
    val pollInterval: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("POLL_INTERVAL")

    /** Database column PROTOCOL_STATUS SqlType(VARCHAR2), Length(16,true) */
    val protocolStatus: Rep[String] = column[String]("PROTOCOL_STATUS", O.Length(16, varying = true))

    /** Database column GATEWAYURL SqlType(VARCHAR2), Length(255,true) */
    val gatewayurl: Rep[String] = column[String]("GATEWAYURL", O.Length(255, varying = true))
  }

  /** Collection-like TableQuery object for table GovtalkStatusBackup */
  lazy val GovtalkStatusBackup = new TableQuery(tag => new GovtalkStatusBackup(tag))

  /** Entity class storing rows of table Land
    * @param landId
    *   Database column LAND_ID SqlType(NUMBER), PrimaryKey
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param propertyType
    *   Database column PROPERTY_TYPE SqlType(VARCHAR2), Length(500,true)
    * @param interestTransferredCreated
    *   Database column INTEREST_TRANSFERRED_CREATED SqlType(VARCHAR2), Length(500,true)
    * @param houseNumber
    *   Database column HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param address1
    *   Database column ADDRESS_1 SqlType(VARCHAR2), Length(500,true)
    * @param address2
    *   Database column ADDRESS_2 SqlType(VARCHAR2), Length(500,true)
    * @param address3
    *   Database column ADDRESS_3 SqlType(VARCHAR2), Length(500,true)
    * @param address4
    *   Database column ADDRESS_4 SqlType(VARCHAR2), Length(500,true)
    * @param postcode
    *   Database column POSTCODE SqlType(VARCHAR2), Length(500,true)
    * @param landArea
    *   Database column LAND_AREA SqlType(VARCHAR2), Length(500,true)
    * @param areaUnit
    *   Database column AREA_UNIT SqlType(VARCHAR2), Length(500,true)
    * @param localAuthorityNumber
    *   Database column LOCAL_AUTHORITY_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param mineralRights
    *   Database column MINERAL_RIGHTS SqlType(VARCHAR2), Length(500,true)
    * @param nlpgUprn
    *   Database column NLPG_UPRN SqlType(VARCHAR2), Length(500,true)
    * @param willSendPlanByPost
    *   Database column WILL_SEND_PLAN_BY_POST SqlType(VARCHAR2), Length(3,true)
    * @param titleNumber
    *   Database column TITLE_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param landResourceRef
    *   Database column LAND_RESOURCE_REF SqlType(NUMBER)
    * @param nextLandId
    *   Database column NEXT_LAND_ID SqlType(NUMBER)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    */
  case class LandRow(
    landId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    propertyType: Option[String],
    interestTransferredCreated: Option[String],
    houseNumber: Option[String],
    address1: Option[String],
    address2: Option[String],
    address3: Option[String],
    address4: Option[String],
    postcode: Option[String],
    landArea: Option[String],
    areaUnit: Option[String],
    localAuthorityNumber: Option[String],
    mineralRights: Option[String],
    nlpgUprn: Option[String],
    willSendPlanByPost: Option[String],
    titleNumber: Option[String],
    landResourceRef: Option[scala.math.BigDecimal],
    nextLandId: Option[scala.math.BigDecimal],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp
  )

  /** GetResult implicit for fetching LandRow objects using plain SQL queries */
  implicit def GetResultLandRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[String]],
    e2: GR[Option[scala.math.BigDecimal]],
    e3: GR[java.sql.Timestamp]
  ): GR[LandRow] = GR { prs =>
    import prs._
    (LandRow.apply _).tupled(
      (
        <<[scala.math.BigDecimal],
        <<[scala.math.BigDecimal],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<[java.sql.Timestamp],
        <<[java.sql.Timestamp]
      )
    )
  }

  /** Table description of table LAND. Objects of this class serve as prototypes for rows in queries. */
  class Land(_tableTag: Tag) extends profile.api.Table[LandRow](_tableTag, Some("SDLT_FILE_DATA"), "LAND") {
    def * = (
      (
        landId,
        returnId,
        propertyType,
        interestTransferredCreated,
        houseNumber,
        address1,
        address2,
        address3,
        address4,
        postcode,
        landArea,
        areaUnit,
        localAuthorityNumber,
        mineralRights,
        nlpgUprn,
        willSendPlanByPost,
        titleNumber,
        landResourceRef,
        nextLandId,
        lMigrated,
        createDate,
        lastUpdateDate
      )
    ).mapTo[LandRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(landId),
        Rep.Some(returnId),
        propertyType,
        interestTransferredCreated,
        houseNumber,
        address1,
        address2,
        address3,
        address4,
        postcode,
        landArea,
        areaUnit,
        localAuthorityNumber,
        mineralRights,
        nlpgUprn,
        willSendPlanByPost,
        titleNumber,
        landResourceRef,
        nextLandId,
        lMigrated,
        Rep.Some(createDate),
        Rep.Some(lastUpdateDate)
      )
    ).shaped.<>(
      { r =>
        import r._;
        _1.map(_ =>
          (LandRow.apply _).tupled(
            (
              _1.get,
              _2.get,
              _3,
              _4,
              _5,
              _6,
              _7,
              _8,
              _9,
              _10,
              _11,
              _12,
              _13,
              _14,
              _15,
              _16,
              _17,
              _18,
              _19,
              _20,
              _21.get,
              _22.get
            )
          )
        )
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column LAND_ID SqlType(NUMBER), PrimaryKey */
    val landId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("LAND_ID", O.PrimaryKey)

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column PROPERTY_TYPE SqlType(VARCHAR2), Length(500,true) */
    val propertyType: Rep[Option[String]] = column[Option[String]]("PROPERTY_TYPE", O.Length(500, varying = true))

    /** Database column INTEREST_TRANSFERRED_CREATED SqlType(VARCHAR2), Length(500,true) */
    val interestTransferredCreated: Rep[Option[String]] =
      column[Option[String]]("INTEREST_TRANSFERRED_CREATED", O.Length(500, varying = true))

    /** Database column HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val houseNumber: Rep[Option[String]] = column[Option[String]]("HOUSE_NUMBER", O.Length(500, varying = true))

    /** Database column ADDRESS_1 SqlType(VARCHAR2), Length(500,true) */
    val address1: Rep[Option[String]] = column[Option[String]]("ADDRESS_1", O.Length(500, varying = true))

    /** Database column ADDRESS_2 SqlType(VARCHAR2), Length(500,true) */
    val address2: Rep[Option[String]] = column[Option[String]]("ADDRESS_2", O.Length(500, varying = true))

    /** Database column ADDRESS_3 SqlType(VARCHAR2), Length(500,true) */
    val address3: Rep[Option[String]] = column[Option[String]]("ADDRESS_3", O.Length(500, varying = true))

    /** Database column ADDRESS_4 SqlType(VARCHAR2), Length(500,true) */
    val address4: Rep[Option[String]] = column[Option[String]]("ADDRESS_4", O.Length(500, varying = true))

    /** Database column POSTCODE SqlType(VARCHAR2), Length(500,true) */
    val postcode: Rep[Option[String]] = column[Option[String]]("POSTCODE", O.Length(500, varying = true))

    /** Database column LAND_AREA SqlType(VARCHAR2), Length(500,true) */
    val landArea: Rep[Option[String]] = column[Option[String]]("LAND_AREA", O.Length(500, varying = true))

    /** Database column AREA_UNIT SqlType(VARCHAR2), Length(500,true) */
    val areaUnit: Rep[Option[String]] = column[Option[String]]("AREA_UNIT", O.Length(500, varying = true))

    /** Database column LOCAL_AUTHORITY_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val localAuthorityNumber: Rep[Option[String]] =
      column[Option[String]]("LOCAL_AUTHORITY_NUMBER", O.Length(500, varying = true))

    /** Database column MINERAL_RIGHTS SqlType(VARCHAR2), Length(500,true) */
    val mineralRights: Rep[Option[String]] = column[Option[String]]("MINERAL_RIGHTS", O.Length(500, varying = true))

    /** Database column NLPG_UPRN SqlType(VARCHAR2), Length(500,true) */
    val nlpgUprn: Rep[Option[String]] = column[Option[String]]("NLPG_UPRN", O.Length(500, varying = true))

    /** Database column WILL_SEND_PLAN_BY_POST SqlType(VARCHAR2), Length(3,true) */
    val willSendPlanByPost: Rep[Option[String]] =
      column[Option[String]]("WILL_SEND_PLAN_BY_POST", O.Length(3, varying = true))

    /** Database column TITLE_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val titleNumber: Rep[Option[String]] = column[Option[String]]("TITLE_NUMBER", O.Length(500, varying = true))

    /** Database column LAND_RESOURCE_REF SqlType(NUMBER) */
    val landResourceRef: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("LAND_RESOURCE_REF")

    /** Database column NEXT_LAND_ID SqlType(NUMBER) */
    val nextLandId: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("NEXT_LAND_ID")

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")

    /** Foreign key referencing Land (database name LAND_LAND_FK) */
    lazy val landFk = foreignKey("LAND_LAND_FK", nextLandId, Land)(
      r => Rep.Some(r.landId),
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )

    /** Foreign key referencing Return (database name LAND_RETURN_FK) */
    lazy val returnFk = foreignKey("LAND_RETURN_FK", returnId, Return)(
      r => r.returnId,
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )
  }

  /** Collection-like TableQuery object for table Land */
  lazy val Land = new TableQuery(tag => new Land(tag))

  /** Entity class storing rows of table LandBackup
    * @param landId
    *   Database column LAND_ID SqlType(NUMBER)
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param propertyType
    *   Database column PROPERTY_TYPE SqlType(VARCHAR2), Length(500,true)
    * @param interestTransferredCreated
    *   Database column INTEREST_TRANSFERRED_CREATED SqlType(VARCHAR2), Length(500,true)
    * @param houseNumber
    *   Database column HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param address1
    *   Database column ADDRESS_1 SqlType(VARCHAR2), Length(500,true)
    * @param address2
    *   Database column ADDRESS_2 SqlType(VARCHAR2), Length(500,true)
    * @param address3
    *   Database column ADDRESS_3 SqlType(VARCHAR2), Length(500,true)
    * @param address4
    *   Database column ADDRESS_4 SqlType(VARCHAR2), Length(500,true)
    * @param postcode
    *   Database column POSTCODE SqlType(VARCHAR2), Length(500,true)
    * @param landArea
    *   Database column LAND_AREA SqlType(VARCHAR2), Length(500,true)
    * @param areaUnit
    *   Database column AREA_UNIT SqlType(VARCHAR2), Length(500,true)
    * @param localAuthorityNumber
    *   Database column LOCAL_AUTHORITY_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param mineralRights
    *   Database column MINERAL_RIGHTS SqlType(VARCHAR2), Length(500,true)
    * @param nlpgUprn
    *   Database column NLPG_UPRN SqlType(VARCHAR2), Length(500,true)
    * @param willSendPlanByPost
    *   Database column WILL_SEND_PLAN_BY_POST SqlType(VARCHAR2), Length(3,true)
    * @param titleNumber
    *   Database column TITLE_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param landResourceRef
    *   Database column LAND_RESOURCE_REF SqlType(NUMBER)
    * @param nextLandId
    *   Database column NEXT_LAND_ID SqlType(NUMBER)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    */
  case class LandBackupRow(
    landId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    propertyType: Option[String],
    interestTransferredCreated: Option[String],
    houseNumber: Option[String],
    address1: Option[String],
    address2: Option[String],
    address3: Option[String],
    address4: Option[String],
    postcode: Option[String],
    landArea: Option[String],
    areaUnit: Option[String],
    localAuthorityNumber: Option[String],
    mineralRights: Option[String],
    nlpgUprn: Option[String],
    willSendPlanByPost: Option[String],
    titleNumber: Option[String],
    landResourceRef: Option[scala.math.BigDecimal],
    nextLandId: Option[scala.math.BigDecimal],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp
  )

  /** GetResult implicit for fetching LandBackupRow objects using plain SQL queries */
  implicit def GetResultLandBackupRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[String]],
    e2: GR[Option[scala.math.BigDecimal]],
    e3: GR[java.sql.Timestamp]
  ): GR[LandBackupRow] = GR { prs =>
    import prs._
    (LandBackupRow.apply _).tupled(
      (
        <<[scala.math.BigDecimal],
        <<[scala.math.BigDecimal],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<[java.sql.Timestamp],
        <<[java.sql.Timestamp]
      )
    )
  }

  /** Table description of table LAND_BACKUP. Objects of this class serve as prototypes for rows in queries. */
  class LandBackup(_tableTag: Tag)
      extends profile.api.Table[LandBackupRow](_tableTag, Some("SDLT_FILE_DATA"), "LAND_BACKUP") {
    def * = (
      (
        landId,
        returnId,
        propertyType,
        interestTransferredCreated,
        houseNumber,
        address1,
        address2,
        address3,
        address4,
        postcode,
        landArea,
        areaUnit,
        localAuthorityNumber,
        mineralRights,
        nlpgUprn,
        willSendPlanByPost,
        titleNumber,
        landResourceRef,
        nextLandId,
        lMigrated,
        createDate,
        lastUpdateDate
      )
    ).mapTo[LandBackupRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(landId),
        Rep.Some(returnId),
        propertyType,
        interestTransferredCreated,
        houseNumber,
        address1,
        address2,
        address3,
        address4,
        postcode,
        landArea,
        areaUnit,
        localAuthorityNumber,
        mineralRights,
        nlpgUprn,
        willSendPlanByPost,
        titleNumber,
        landResourceRef,
        nextLandId,
        lMigrated,
        Rep.Some(createDate),
        Rep.Some(lastUpdateDate)
      )
    ).shaped.<>(
      { r =>
        import r._;
        _1.map(_ =>
          (LandBackupRow.apply _).tupled(
            (
              _1.get,
              _2.get,
              _3,
              _4,
              _5,
              _6,
              _7,
              _8,
              _9,
              _10,
              _11,
              _12,
              _13,
              _14,
              _15,
              _16,
              _17,
              _18,
              _19,
              _20,
              _21.get,
              _22.get
            )
          )
        )
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column LAND_ID SqlType(NUMBER) */
    val landId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("LAND_ID")

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column PROPERTY_TYPE SqlType(VARCHAR2), Length(500,true) */
    val propertyType: Rep[Option[String]] = column[Option[String]]("PROPERTY_TYPE", O.Length(500, varying = true))

    /** Database column INTEREST_TRANSFERRED_CREATED SqlType(VARCHAR2), Length(500,true) */
    val interestTransferredCreated: Rep[Option[String]] =
      column[Option[String]]("INTEREST_TRANSFERRED_CREATED", O.Length(500, varying = true))

    /** Database column HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val houseNumber: Rep[Option[String]] = column[Option[String]]("HOUSE_NUMBER", O.Length(500, varying = true))

    /** Database column ADDRESS_1 SqlType(VARCHAR2), Length(500,true) */
    val address1: Rep[Option[String]] = column[Option[String]]("ADDRESS_1", O.Length(500, varying = true))

    /** Database column ADDRESS_2 SqlType(VARCHAR2), Length(500,true) */
    val address2: Rep[Option[String]] = column[Option[String]]("ADDRESS_2", O.Length(500, varying = true))

    /** Database column ADDRESS_3 SqlType(VARCHAR2), Length(500,true) */
    val address3: Rep[Option[String]] = column[Option[String]]("ADDRESS_3", O.Length(500, varying = true))

    /** Database column ADDRESS_4 SqlType(VARCHAR2), Length(500,true) */
    val address4: Rep[Option[String]] = column[Option[String]]("ADDRESS_4", O.Length(500, varying = true))

    /** Database column POSTCODE SqlType(VARCHAR2), Length(500,true) */
    val postcode: Rep[Option[String]] = column[Option[String]]("POSTCODE", O.Length(500, varying = true))

    /** Database column LAND_AREA SqlType(VARCHAR2), Length(500,true) */
    val landArea: Rep[Option[String]] = column[Option[String]]("LAND_AREA", O.Length(500, varying = true))

    /** Database column AREA_UNIT SqlType(VARCHAR2), Length(500,true) */
    val areaUnit: Rep[Option[String]] = column[Option[String]]("AREA_UNIT", O.Length(500, varying = true))

    /** Database column LOCAL_AUTHORITY_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val localAuthorityNumber: Rep[Option[String]] =
      column[Option[String]]("LOCAL_AUTHORITY_NUMBER", O.Length(500, varying = true))

    /** Database column MINERAL_RIGHTS SqlType(VARCHAR2), Length(500,true) */
    val mineralRights: Rep[Option[String]] = column[Option[String]]("MINERAL_RIGHTS", O.Length(500, varying = true))

    /** Database column NLPG_UPRN SqlType(VARCHAR2), Length(500,true) */
    val nlpgUprn: Rep[Option[String]] = column[Option[String]]("NLPG_UPRN", O.Length(500, varying = true))

    /** Database column WILL_SEND_PLAN_BY_POST SqlType(VARCHAR2), Length(3,true) */
    val willSendPlanByPost: Rep[Option[String]] =
      column[Option[String]]("WILL_SEND_PLAN_BY_POST", O.Length(3, varying = true))

    /** Database column TITLE_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val titleNumber: Rep[Option[String]] = column[Option[String]]("TITLE_NUMBER", O.Length(500, varying = true))

    /** Database column LAND_RESOURCE_REF SqlType(NUMBER) */
    val landResourceRef: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("LAND_RESOURCE_REF")

    /** Database column NEXT_LAND_ID SqlType(NUMBER) */
    val nextLandId: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("NEXT_LAND_ID")

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")
  }

  /** Collection-like TableQuery object for table LandBackup */
  lazy val LandBackup = new TableQuery(tag => new LandBackup(tag))

  /** Entity class storing rows of table Lease
    * @param leaseId
    *   Database column LEASE_ID SqlType(NUMBER), PrimaryKey
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param isAnnualRentOver1000
    *   Database column IS_ANNUAL_RENT_OVER_1000 SqlType(VARCHAR2), Length(3,true)
    * @param breakClauseType
    *   Database column BREAK_CLAUSE_TYPE SqlType(VARCHAR2), Length(500,true)
    * @param breakClauseDate
    *   Database column BREAK_CLAUSE_DATE SqlType(VARCHAR2), Length(500,true)
    * @param leaseContReservedRent
    *   Database column LEASE_CONT_RESERVED_RENT SqlType(VARCHAR2), Length(500,true)
    * @param contractEndDate
    *   Database column CONTRACT_END_DATE SqlType(VARCHAR2), Length(500,true)
    * @param contractStartDate
    *   Database column CONTRACT_START_DATE SqlType(VARCHAR2), Length(500,true)
    * @param firstReviewDate
    *   Database column FIRST_REVIEW_DATE SqlType(VARCHAR2), Length(500,true)
    * @param leaseType
    *   Database column LEASE_TYPE SqlType(VARCHAR2), Length(500,true)
    * @param marketRent
    *   Database column MARKET_RENT SqlType(VARCHAR2), Length(500,true)
    * @param netPresentValue
    *   Database column NET_PRESENT_VALUE SqlType(VARCHAR2), Length(500,true)
    * @param optionToRenew
    *   Database column OPTION_TO_RENEW SqlType(VARCHAR2), Length(500,true)
    * @param totalPremiumPayable
    *   Database column TOTAL_PREMIUM_PAYABLE SqlType(VARCHAR2), Length(500,true)
    * @param rentChargeDate
    *   Database column RENT_CHARGE_DATE SqlType(VARCHAR2), Length(500,true)
    * @param rentFreePeriod
    *   Database column RENT_FREE_PERIOD SqlType(VARCHAR2), Length(500,true)
    * @param reviewClauseType
    *   Database column REVIEW_CLAUSE_TYPE SqlType(VARCHAR2), Length(500,true)
    * @param rentReviewFrequency
    *   Database column RENT_REVIEW_FREQUENCY SqlType(VARCHAR2), Length(500,true)
    * @param serviceCharge
    *   Database column SERVICE_CHARGE SqlType(VARCHAR2), Length(500,true)
    * @param serviceChargeFrequency
    *   Database column SERVICE_CHARGE_FREQUENCY SqlType(VARCHAR2), Length(500,true)
    * @param startingRent
    *   Database column STARTING_RENT SqlType(VARCHAR2), Length(500,true)
    * @param startingRentEndDate
    *   Database column STARTING_RENT_END_DATE SqlType(VARCHAR2), Length(500,true)
    * @param laterRentKnown
    *   Database column LATER_RENT_KNOWN SqlType(VARCHAR2), Length(3,true)
    * @param termsSurrendered
    *   Database column TERMS_SURRENDERED SqlType(VARCHAR2), Length(500,true)
    * @param considToLndlrdBuild
    *   Database column CONSID_TO_LNDLRD_BUILD SqlType(VARCHAR2), Length(3,true)
    * @param considToLndlrdContin
    *   Database column CONSID_TO_LNDLRD_CONTIN SqlType(VARCHAR2), Length(3,true)
    * @param considToLndlrdDebt
    *   Database column CONSID_TO_LNDLRD_DEBT SqlType(VARCHAR2), Length(3,true)
    * @param considToLndlrdEmploy
    *   Database column CONSID_TO_LNDLRD_EMPLOY SqlType(VARCHAR2), Length(3,true)
    * @param considToLndlrdOther
    *   Database column CONSID_TO_LNDLRD_OTHER SqlType(VARCHAR2), Length(3,true)
    * @param considToLndlrdLand
    *   Database column CONSID_TO_LNDLRD_LAND SqlType(VARCHAR2), Length(3,true)
    * @param considToLndlrdServices
    *   Database column CONSID_TO_LNDLRD_SERVICES SqlType(VARCHAR2), Length(3,true)
    * @param considToLndlrdSharedQtd
    *   Database column CONSID_TO_LNDLRD_SHARED_QTD SqlType(VARCHAR2), Length(3,true)
    * @param considToLndlrdSharedUnqtd
    *   Database column CONSID_TO_LNDLRD_SHARED_UNQTD SqlType(VARCHAR2), Length(3,true)
    * @param considToTenantBuild
    *   Database column CONSID_TO_TENANT_BUILD SqlType(VARCHAR2), Length(3,true)
    * @param considToTenantContin
    *   Database column CONSID_TO_TENANT_CONTIN SqlType(VARCHAR2), Length(3,true)
    * @param considToTenantEmploy
    *   Database column CONSID_TO_TENANT_EMPLOY SqlType(VARCHAR2), Length(3,true)
    * @param considToTenantOther
    *   Database column CONSID_TO_TENANT_OTHER SqlType(VARCHAR2), Length(3,true)
    * @param considToTenantLand
    *   Database column CONSID_TO_TENANT_LAND SqlType(VARCHAR2), Length(3,true)
    * @param considToTenantServices
    *   Database column CONSID_TO_TENANT_SERVICES SqlType(VARCHAR2), Length(3,true)
    * @param considToTenantSharesQtd
    *   Database column CONSID_TO_TENANT_SHARES_QTD SqlType(VARCHAR2), Length(3,true)
    * @param considToTenantSharesUnqtd
    *   Database column CONSID_TO_TENANT_SHARES_UNQTD SqlType(VARCHAR2), Length(3,true)
    * @param turnoverRent
    *   Database column TURNOVER_RENT SqlType(VARCHAR2), Length(500,true)
    * @param unasertainableRent
    *   Database column UNASERTAINABLE_RENT SqlType(VARCHAR2), Length(500,true)
    * @param vatAmount
    *   Database column VAT_AMOUNT SqlType(VARCHAR2), Length(500,true)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    */
  case class LeaseRow(
    leaseId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    isAnnualRentOver1000: Option[String],
    breakClauseType: Option[String],
    breakClauseDate: Option[String],
    leaseContReservedRent: Option[String],
    contractEndDate: Option[String],
    contractStartDate: Option[String],
    firstReviewDate: Option[String],
    leaseType: Option[String],
    marketRent: Option[String],
    netPresentValue: Option[String],
    optionToRenew: Option[String],
    totalPremiumPayable: Option[String],
    rentChargeDate: Option[String],
    rentFreePeriod: Option[String],
    reviewClauseType: Option[String],
    rentReviewFrequency: Option[String],
    serviceCharge: Option[String],
    serviceChargeFrequency: Option[String],
    startingRent: Option[String],
    startingRentEndDate: Option[String],
    laterRentKnown: Option[String],
    termsSurrendered: Option[String],
    considToLndlrdBuild: Option[String],
    considToLndlrdContin: Option[String],
    considToLndlrdDebt: Option[String],
    considToLndlrdEmploy: Option[String],
    considToLndlrdOther: Option[String],
    considToLndlrdLand: Option[String],
    considToLndlrdServices: Option[String],
    considToLndlrdSharedQtd: Option[String],
    considToLndlrdSharedUnqtd: Option[String],
    considToTenantBuild: Option[String],
    considToTenantContin: Option[String],
    considToTenantEmploy: Option[String],
    considToTenantOther: Option[String],
    considToTenantLand: Option[String],
    considToTenantServices: Option[String],
    considToTenantSharesQtd: Option[String],
    considToTenantSharesUnqtd: Option[String],
    turnoverRent: Option[String],
    unasertainableRent: Option[String],
    vatAmount: Option[String],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp
  )

  /** GetResult implicit for fetching LeaseRow objects using plain SQL queries */
  implicit def GetResultLeaseRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[String]],
    e2: GR[Option[scala.math.BigDecimal]],
    e3: GR[java.sql.Timestamp]
  ): GR[LeaseRow] = GR { prs =>
    import prs._
    LeaseRow(
      <<[scala.math.BigDecimal],
      <<[scala.math.BigDecimal],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[scala.math.BigDecimal],
      <<[java.sql.Timestamp],
      <<[java.sql.Timestamp]
    )
  }

  /** Table description of table LEASE. Objects of this class serve as prototypes for rows in queries. */
  class Lease(_tableTag: Tag) extends profile.api.Table[LeaseRow](_tableTag, Some("SDLT_FILE_DATA"), "LEASE") {
    def * =
      (leaseId :: returnId :: isAnnualRentOver1000 :: breakClauseType :: breakClauseDate :: leaseContReservedRent :: contractEndDate :: contractStartDate :: firstReviewDate :: leaseType :: marketRent :: netPresentValue :: optionToRenew :: totalPremiumPayable :: rentChargeDate :: rentFreePeriod :: reviewClauseType :: rentReviewFrequency :: serviceCharge :: serviceChargeFrequency :: startingRent :: startingRentEndDate :: laterRentKnown :: termsSurrendered :: considToLndlrdBuild :: considToLndlrdContin :: considToLndlrdDebt :: considToLndlrdEmploy :: considToLndlrdOther :: considToLndlrdLand :: considToLndlrdServices :: considToLndlrdSharedQtd :: considToLndlrdSharedUnqtd :: considToTenantBuild :: considToTenantContin :: considToTenantEmploy :: considToTenantOther :: considToTenantLand :: considToTenantServices :: considToTenantSharesQtd :: considToTenantSharesUnqtd :: turnoverRent :: unasertainableRent :: vatAmount :: lMigrated :: createDate :: lastUpdateDate :: HNil)
        .mapTo[LeaseRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(leaseId) :: Rep.Some(
      returnId
    ) :: isAnnualRentOver1000 :: breakClauseType :: breakClauseDate :: leaseContReservedRent :: contractEndDate :: contractStartDate :: firstReviewDate :: leaseType :: marketRent :: netPresentValue :: optionToRenew :: totalPremiumPayable :: rentChargeDate :: rentFreePeriod :: reviewClauseType :: rentReviewFrequency :: serviceCharge :: serviceChargeFrequency :: startingRent :: startingRentEndDate :: laterRentKnown :: termsSurrendered :: considToLndlrdBuild :: considToLndlrdContin :: considToLndlrdDebt :: considToLndlrdEmploy :: considToLndlrdOther :: considToLndlrdLand :: considToLndlrdServices :: considToLndlrdSharedQtd :: considToLndlrdSharedUnqtd :: considToTenantBuild :: considToTenantContin :: considToTenantEmploy :: considToTenantOther :: considToTenantLand :: considToTenantServices :: considToTenantSharesQtd :: considToTenantSharesUnqtd :: turnoverRent :: unasertainableRent :: vatAmount :: lMigrated :: Rep
      .Some(createDate) :: Rep.Some(lastUpdateDate) :: HNil).shaped.<>(
      r =>
        LeaseRow(
          r.productElement(0).asInstanceOf[Option[scala.math.BigDecimal]].get,
          r.productElement(1).asInstanceOf[Option[scala.math.BigDecimal]].get,
          r.productElement(2).asInstanceOf[Option[String]],
          r.productElement(3).asInstanceOf[Option[String]],
          r.productElement(4).asInstanceOf[Option[String]],
          r.productElement(5).asInstanceOf[Option[String]],
          r.productElement(6).asInstanceOf[Option[String]],
          r.productElement(7).asInstanceOf[Option[String]],
          r.productElement(8).asInstanceOf[Option[String]],
          r.productElement(9).asInstanceOf[Option[String]],
          r.productElement(10).asInstanceOf[Option[String]],
          r.productElement(11).asInstanceOf[Option[String]],
          r.productElement(12).asInstanceOf[Option[String]],
          r.productElement(13).asInstanceOf[Option[String]],
          r.productElement(14).asInstanceOf[Option[String]],
          r.productElement(15).asInstanceOf[Option[String]],
          r.productElement(16).asInstanceOf[Option[String]],
          r.productElement(17).asInstanceOf[Option[String]],
          r.productElement(18).asInstanceOf[Option[String]],
          r.productElement(19).asInstanceOf[Option[String]],
          r.productElement(20).asInstanceOf[Option[String]],
          r.productElement(21).asInstanceOf[Option[String]],
          r.productElement(22).asInstanceOf[Option[String]],
          r.productElement(23).asInstanceOf[Option[String]],
          r.productElement(24).asInstanceOf[Option[String]],
          r.productElement(25).asInstanceOf[Option[String]],
          r.productElement(26).asInstanceOf[Option[String]],
          r.productElement(27).asInstanceOf[Option[String]],
          r.productElement(28).asInstanceOf[Option[String]],
          r.productElement(29).asInstanceOf[Option[String]],
          r.productElement(30).asInstanceOf[Option[String]],
          r.productElement(31).asInstanceOf[Option[String]],
          r.productElement(32).asInstanceOf[Option[String]],
          r.productElement(33).asInstanceOf[Option[String]],
          r.productElement(34).asInstanceOf[Option[String]],
          r.productElement(35).asInstanceOf[Option[String]],
          r.productElement(36).asInstanceOf[Option[String]],
          r.productElement(37).asInstanceOf[Option[String]],
          r.productElement(38).asInstanceOf[Option[String]],
          r.productElement(39).asInstanceOf[Option[String]],
          r.productElement(40).asInstanceOf[Option[String]],
          r.productElement(41).asInstanceOf[Option[String]],
          r.productElement(42).asInstanceOf[Option[String]],
          r.productElement(43).asInstanceOf[Option[String]],
          r.productElement(44).asInstanceOf[Option[scala.math.BigDecimal]],
          r.productElement(45).asInstanceOf[Option[java.sql.Timestamp]].get,
          r.productElement(46).asInstanceOf[Option[java.sql.Timestamp]].get
        ),
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column LEASE_ID SqlType(NUMBER), PrimaryKey */
    val leaseId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("LEASE_ID", O.PrimaryKey)

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column IS_ANNUAL_RENT_OVER_1000 SqlType(VARCHAR2), Length(3,true) */
    val isAnnualRentOver1000: Rep[Option[String]] =
      column[Option[String]]("IS_ANNUAL_RENT_OVER_1000", O.Length(3, varying = true))

    /** Database column BREAK_CLAUSE_TYPE SqlType(VARCHAR2), Length(500,true) */
    val breakClauseType: Rep[Option[String]] =
      column[Option[String]]("BREAK_CLAUSE_TYPE", O.Length(500, varying = true))

    /** Database column BREAK_CLAUSE_DATE SqlType(VARCHAR2), Length(500,true) */
    val breakClauseDate: Rep[Option[String]] =
      column[Option[String]]("BREAK_CLAUSE_DATE", O.Length(500, varying = true))

    /** Database column LEASE_CONT_RESERVED_RENT SqlType(VARCHAR2), Length(500,true) */
    val leaseContReservedRent: Rep[Option[String]] =
      column[Option[String]]("LEASE_CONT_RESERVED_RENT", O.Length(500, varying = true))

    /** Database column CONTRACT_END_DATE SqlType(VARCHAR2), Length(500,true) */
    val contractEndDate: Rep[Option[String]] =
      column[Option[String]]("CONTRACT_END_DATE", O.Length(500, varying = true))

    /** Database column CONTRACT_START_DATE SqlType(VARCHAR2), Length(500,true) */
    val contractStartDate: Rep[Option[String]] =
      column[Option[String]]("CONTRACT_START_DATE", O.Length(500, varying = true))

    /** Database column FIRST_REVIEW_DATE SqlType(VARCHAR2), Length(500,true) */
    val firstReviewDate: Rep[Option[String]] =
      column[Option[String]]("FIRST_REVIEW_DATE", O.Length(500, varying = true))

    /** Database column LEASE_TYPE SqlType(VARCHAR2), Length(500,true) */
    val leaseType: Rep[Option[String]] = column[Option[String]]("LEASE_TYPE", O.Length(500, varying = true))

    /** Database column MARKET_RENT SqlType(VARCHAR2), Length(500,true) */
    val marketRent: Rep[Option[String]] = column[Option[String]]("MARKET_RENT", O.Length(500, varying = true))

    /** Database column NET_PRESENT_VALUE SqlType(VARCHAR2), Length(500,true) */
    val netPresentValue: Rep[Option[String]] =
      column[Option[String]]("NET_PRESENT_VALUE", O.Length(500, varying = true))

    /** Database column OPTION_TO_RENEW SqlType(VARCHAR2), Length(500,true) */
    val optionToRenew: Rep[Option[String]] = column[Option[String]]("OPTION_TO_RENEW", O.Length(500, varying = true))

    /** Database column TOTAL_PREMIUM_PAYABLE SqlType(VARCHAR2), Length(500,true) */
    val totalPremiumPayable: Rep[Option[String]] =
      column[Option[String]]("TOTAL_PREMIUM_PAYABLE", O.Length(500, varying = true))

    /** Database column RENT_CHARGE_DATE SqlType(VARCHAR2), Length(500,true) */
    val rentChargeDate: Rep[Option[String]] = column[Option[String]]("RENT_CHARGE_DATE", O.Length(500, varying = true))

    /** Database column RENT_FREE_PERIOD SqlType(VARCHAR2), Length(500,true) */
    val rentFreePeriod: Rep[Option[String]] = column[Option[String]]("RENT_FREE_PERIOD", O.Length(500, varying = true))

    /** Database column REVIEW_CLAUSE_TYPE SqlType(VARCHAR2), Length(500,true) */
    val reviewClauseType: Rep[Option[String]] =
      column[Option[String]]("REVIEW_CLAUSE_TYPE", O.Length(500, varying = true))

    /** Database column RENT_REVIEW_FREQUENCY SqlType(VARCHAR2), Length(500,true) */
    val rentReviewFrequency: Rep[Option[String]] =
      column[Option[String]]("RENT_REVIEW_FREQUENCY", O.Length(500, varying = true))

    /** Database column SERVICE_CHARGE SqlType(VARCHAR2), Length(500,true) */
    val serviceCharge: Rep[Option[String]] = column[Option[String]]("SERVICE_CHARGE", O.Length(500, varying = true))

    /** Database column SERVICE_CHARGE_FREQUENCY SqlType(VARCHAR2), Length(500,true) */
    val serviceChargeFrequency: Rep[Option[String]] =
      column[Option[String]]("SERVICE_CHARGE_FREQUENCY", O.Length(500, varying = true))

    /** Database column STARTING_RENT SqlType(VARCHAR2), Length(500,true) */
    val startingRent: Rep[Option[String]] = column[Option[String]]("STARTING_RENT", O.Length(500, varying = true))

    /** Database column STARTING_RENT_END_DATE SqlType(VARCHAR2), Length(500,true) */
    val startingRentEndDate: Rep[Option[String]] =
      column[Option[String]]("STARTING_RENT_END_DATE", O.Length(500, varying = true))

    /** Database column LATER_RENT_KNOWN SqlType(VARCHAR2), Length(3,true) */
    val laterRentKnown: Rep[Option[String]] = column[Option[String]]("LATER_RENT_KNOWN", O.Length(3, varying = true))

    /** Database column TERMS_SURRENDERED SqlType(VARCHAR2), Length(500,true) */
    val termsSurrendered: Rep[Option[String]] =
      column[Option[String]]("TERMS_SURRENDERED", O.Length(500, varying = true))

    /** Database column CONSID_TO_LNDLRD_BUILD SqlType(VARCHAR2), Length(3,true) */
    val considToLndlrdBuild: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_LNDLRD_BUILD", O.Length(3, varying = true))

    /** Database column CONSID_TO_LNDLRD_CONTIN SqlType(VARCHAR2), Length(3,true) */
    val considToLndlrdContin: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_LNDLRD_CONTIN", O.Length(3, varying = true))

    /** Database column CONSID_TO_LNDLRD_DEBT SqlType(VARCHAR2), Length(3,true) */
    val considToLndlrdDebt: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_LNDLRD_DEBT", O.Length(3, varying = true))

    /** Database column CONSID_TO_LNDLRD_EMPLOY SqlType(VARCHAR2), Length(3,true) */
    val considToLndlrdEmploy: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_LNDLRD_EMPLOY", O.Length(3, varying = true))

    /** Database column CONSID_TO_LNDLRD_OTHER SqlType(VARCHAR2), Length(3,true) */
    val considToLndlrdOther: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_LNDLRD_OTHER", O.Length(3, varying = true))

    /** Database column CONSID_TO_LNDLRD_LAND SqlType(VARCHAR2), Length(3,true) */
    val considToLndlrdLand: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_LNDLRD_LAND", O.Length(3, varying = true))

    /** Database column CONSID_TO_LNDLRD_SERVICES SqlType(VARCHAR2), Length(3,true) */
    val considToLndlrdServices: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_LNDLRD_SERVICES", O.Length(3, varying = true))

    /** Database column CONSID_TO_LNDLRD_SHARED_QTD SqlType(VARCHAR2), Length(3,true) */
    val considToLndlrdSharedQtd: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_LNDLRD_SHARED_QTD", O.Length(3, varying = true))

    /** Database column CONSID_TO_LNDLRD_SHARED_UNQTD SqlType(VARCHAR2), Length(3,true) */
    val considToLndlrdSharedUnqtd: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_LNDLRD_SHARED_UNQTD", O.Length(3, varying = true))

    /** Database column CONSID_TO_TENANT_BUILD SqlType(VARCHAR2), Length(3,true) */
    val considToTenantBuild: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_TENANT_BUILD", O.Length(3, varying = true))

    /** Database column CONSID_TO_TENANT_CONTIN SqlType(VARCHAR2), Length(3,true) */
    val considToTenantContin: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_TENANT_CONTIN", O.Length(3, varying = true))

    /** Database column CONSID_TO_TENANT_EMPLOY SqlType(VARCHAR2), Length(3,true) */
    val considToTenantEmploy: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_TENANT_EMPLOY", O.Length(3, varying = true))

    /** Database column CONSID_TO_TENANT_OTHER SqlType(VARCHAR2), Length(3,true) */
    val considToTenantOther: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_TENANT_OTHER", O.Length(3, varying = true))

    /** Database column CONSID_TO_TENANT_LAND SqlType(VARCHAR2), Length(3,true) */
    val considToTenantLand: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_TENANT_LAND", O.Length(3, varying = true))

    /** Database column CONSID_TO_TENANT_SERVICES SqlType(VARCHAR2), Length(3,true) */
    val considToTenantServices: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_TENANT_SERVICES", O.Length(3, varying = true))

    /** Database column CONSID_TO_TENANT_SHARES_QTD SqlType(VARCHAR2), Length(3,true) */
    val considToTenantSharesQtd: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_TENANT_SHARES_QTD", O.Length(3, varying = true))

    /** Database column CONSID_TO_TENANT_SHARES_UNQTD SqlType(VARCHAR2), Length(3,true) */
    val considToTenantSharesUnqtd: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_TENANT_SHARES_UNQTD", O.Length(3, varying = true))

    /** Database column TURNOVER_RENT SqlType(VARCHAR2), Length(500,true) */
    val turnoverRent: Rep[Option[String]] = column[Option[String]]("TURNOVER_RENT", O.Length(500, varying = true))

    /** Database column UNASERTAINABLE_RENT SqlType(VARCHAR2), Length(500,true) */
    val unasertainableRent: Rep[Option[String]] =
      column[Option[String]]("UNASERTAINABLE_RENT", O.Length(500, varying = true))

    /** Database column VAT_AMOUNT SqlType(VARCHAR2), Length(500,true) */
    val vatAmount: Rep[Option[String]] = column[Option[String]]("VAT_AMOUNT", O.Length(500, varying = true))

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")

    /** Foreign key referencing Return (database name LEASE_RETURN_FK) */
    lazy val returnFk = foreignKey("LEASE_RETURN_FK", returnId :: HNil, Return)(
      r => r.returnId :: HNil,
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )
  }

  /** Collection-like TableQuery object for table Lease */
  lazy val Lease = new TableQuery(tag => new Lease(tag))

  /** Entity class storing rows of table LeaseBackup
    * @param leaseId
    *   Database column LEASE_ID SqlType(NUMBER)
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param isAnnualRentOver1000
    *   Database column IS_ANNUAL_RENT_OVER_1000 SqlType(VARCHAR2), Length(3,true)
    * @param breakClauseType
    *   Database column BREAK_CLAUSE_TYPE SqlType(VARCHAR2), Length(500,true)
    * @param breakClauseDate
    *   Database column BREAK_CLAUSE_DATE SqlType(VARCHAR2), Length(500,true)
    * @param leaseContReservedRent
    *   Database column LEASE_CONT_RESERVED_RENT SqlType(VARCHAR2), Length(500,true)
    * @param contractEndDate
    *   Database column CONTRACT_END_DATE SqlType(VARCHAR2), Length(500,true)
    * @param contractStartDate
    *   Database column CONTRACT_START_DATE SqlType(VARCHAR2), Length(500,true)
    * @param firstReviewDate
    *   Database column FIRST_REVIEW_DATE SqlType(VARCHAR2), Length(500,true)
    * @param leaseType
    *   Database column LEASE_TYPE SqlType(VARCHAR2), Length(500,true)
    * @param marketRent
    *   Database column MARKET_RENT SqlType(VARCHAR2), Length(500,true)
    * @param netPresentValue
    *   Database column NET_PRESENT_VALUE SqlType(VARCHAR2), Length(500,true)
    * @param optionToRenew
    *   Database column OPTION_TO_RENEW SqlType(VARCHAR2), Length(500,true)
    * @param totalPremiumPayable
    *   Database column TOTAL_PREMIUM_PAYABLE SqlType(VARCHAR2), Length(500,true)
    * @param rentChargeDate
    *   Database column RENT_CHARGE_DATE SqlType(VARCHAR2), Length(500,true)
    * @param rentFreePeriod
    *   Database column RENT_FREE_PERIOD SqlType(VARCHAR2), Length(500,true)
    * @param reviewClauseType
    *   Database column REVIEW_CLAUSE_TYPE SqlType(VARCHAR2), Length(500,true)
    * @param rentReviewFrequency
    *   Database column RENT_REVIEW_FREQUENCY SqlType(VARCHAR2), Length(500,true)
    * @param serviceCharge
    *   Database column SERVICE_CHARGE SqlType(VARCHAR2), Length(500,true)
    * @param serviceChargeFrequency
    *   Database column SERVICE_CHARGE_FREQUENCY SqlType(VARCHAR2), Length(500,true)
    * @param startingRent
    *   Database column STARTING_RENT SqlType(VARCHAR2), Length(500,true)
    * @param startingRentEndDate
    *   Database column STARTING_RENT_END_DATE SqlType(VARCHAR2), Length(500,true)
    * @param laterRentKnown
    *   Database column LATER_RENT_KNOWN SqlType(VARCHAR2), Length(3,true)
    * @param termsSurrendered
    *   Database column TERMS_SURRENDERED SqlType(VARCHAR2), Length(500,true)
    * @param considToLndlrdBuild
    *   Database column CONSID_TO_LNDLRD_BUILD SqlType(VARCHAR2), Length(3,true)
    * @param considToLndlrdContin
    *   Database column CONSID_TO_LNDLRD_CONTIN SqlType(VARCHAR2), Length(3,true)
    * @param considToLndlrdDebt
    *   Database column CONSID_TO_LNDLRD_DEBT SqlType(VARCHAR2), Length(3,true)
    * @param considToLndlrdEmploy
    *   Database column CONSID_TO_LNDLRD_EMPLOY SqlType(VARCHAR2), Length(3,true)
    * @param considToLndlrdOther
    *   Database column CONSID_TO_LNDLRD_OTHER SqlType(VARCHAR2), Length(3,true)
    * @param considToLndlrdLand
    *   Database column CONSID_TO_LNDLRD_LAND SqlType(VARCHAR2), Length(3,true)
    * @param considToLndlrdServices
    *   Database column CONSID_TO_LNDLRD_SERVICES SqlType(VARCHAR2), Length(3,true)
    * @param considToLndlrdSharedQtd
    *   Database column CONSID_TO_LNDLRD_SHARED_QTD SqlType(VARCHAR2), Length(3,true)
    * @param considToLndlrdSharedUnqtd
    *   Database column CONSID_TO_LNDLRD_SHARED_UNQTD SqlType(VARCHAR2), Length(3,true)
    * @param considToTenantBuild
    *   Database column CONSID_TO_TENANT_BUILD SqlType(VARCHAR2), Length(3,true)
    * @param considToTenantContin
    *   Database column CONSID_TO_TENANT_CONTIN SqlType(VARCHAR2), Length(3,true)
    * @param considToTenantEmploy
    *   Database column CONSID_TO_TENANT_EMPLOY SqlType(VARCHAR2), Length(3,true)
    * @param considToTenantOther
    *   Database column CONSID_TO_TENANT_OTHER SqlType(VARCHAR2), Length(3,true)
    * @param considToTenantLand
    *   Database column CONSID_TO_TENANT_LAND SqlType(VARCHAR2), Length(3,true)
    * @param considToTenantServices
    *   Database column CONSID_TO_TENANT_SERVICES SqlType(VARCHAR2), Length(3,true)
    * @param considToTenantSharesQtd
    *   Database column CONSID_TO_TENANT_SHARES_QTD SqlType(VARCHAR2), Length(3,true)
    * @param considToTenantSharesUnqtd
    *   Database column CONSID_TO_TENANT_SHARES_UNQTD SqlType(VARCHAR2), Length(3,true)
    * @param turnoverRent
    *   Database column TURNOVER_RENT SqlType(VARCHAR2), Length(500,true)
    * @param unasertainableRent
    *   Database column UNASERTAINABLE_RENT SqlType(VARCHAR2), Length(500,true)
    * @param vatAmount
    *   Database column VAT_AMOUNT SqlType(VARCHAR2), Length(500,true)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    */
  case class LeaseBackupRow(
    leaseId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    isAnnualRentOver1000: Option[String],
    breakClauseType: Option[String],
    breakClauseDate: Option[String],
    leaseContReservedRent: Option[String],
    contractEndDate: Option[String],
    contractStartDate: Option[String],
    firstReviewDate: Option[String],
    leaseType: Option[String],
    marketRent: Option[String],
    netPresentValue: Option[String],
    optionToRenew: Option[String],
    totalPremiumPayable: Option[String],
    rentChargeDate: Option[String],
    rentFreePeriod: Option[String],
    reviewClauseType: Option[String],
    rentReviewFrequency: Option[String],
    serviceCharge: Option[String],
    serviceChargeFrequency: Option[String],
    startingRent: Option[String],
    startingRentEndDate: Option[String],
    laterRentKnown: Option[String],
    termsSurrendered: Option[String],
    considToLndlrdBuild: Option[String],
    considToLndlrdContin: Option[String],
    considToLndlrdDebt: Option[String],
    considToLndlrdEmploy: Option[String],
    considToLndlrdOther: Option[String],
    considToLndlrdLand: Option[String],
    considToLndlrdServices: Option[String],
    considToLndlrdSharedQtd: Option[String],
    considToLndlrdSharedUnqtd: Option[String],
    considToTenantBuild: Option[String],
    considToTenantContin: Option[String],
    considToTenantEmploy: Option[String],
    considToTenantOther: Option[String],
    considToTenantLand: Option[String],
    considToTenantServices: Option[String],
    considToTenantSharesQtd: Option[String],
    considToTenantSharesUnqtd: Option[String],
    turnoverRent: Option[String],
    unasertainableRent: Option[String],
    vatAmount: Option[String],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp
  )

  /** GetResult implicit for fetching LeaseBackupRow objects using plain SQL queries */
  implicit def GetResultLeaseBackupRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[String]],
    e2: GR[Option[scala.math.BigDecimal]],
    e3: GR[java.sql.Timestamp]
  ): GR[LeaseBackupRow] = GR { prs =>
    import prs._
    LeaseBackupRow(
      <<[scala.math.BigDecimal],
      <<[scala.math.BigDecimal],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[scala.math.BigDecimal],
      <<[java.sql.Timestamp],
      <<[java.sql.Timestamp]
    )
  }

  /** Table description of table LEASE_BACKUP. Objects of this class serve as prototypes for rows in queries. */
  class LeaseBackup(_tableTag: Tag)
      extends profile.api.Table[LeaseBackupRow](_tableTag, Some("SDLT_FILE_DATA"), "LEASE_BACKUP") {
    def * =
      (leaseId :: returnId :: isAnnualRentOver1000 :: breakClauseType :: breakClauseDate :: leaseContReservedRent :: contractEndDate :: contractStartDate :: firstReviewDate :: leaseType :: marketRent :: netPresentValue :: optionToRenew :: totalPremiumPayable :: rentChargeDate :: rentFreePeriod :: reviewClauseType :: rentReviewFrequency :: serviceCharge :: serviceChargeFrequency :: startingRent :: startingRentEndDate :: laterRentKnown :: termsSurrendered :: considToLndlrdBuild :: considToLndlrdContin :: considToLndlrdDebt :: considToLndlrdEmploy :: considToLndlrdOther :: considToLndlrdLand :: considToLndlrdServices :: considToLndlrdSharedQtd :: considToLndlrdSharedUnqtd :: considToTenantBuild :: considToTenantContin :: considToTenantEmploy :: considToTenantOther :: considToTenantLand :: considToTenantServices :: considToTenantSharesQtd :: considToTenantSharesUnqtd :: turnoverRent :: unasertainableRent :: vatAmount :: lMigrated :: createDate :: lastUpdateDate :: HNil)
        .mapTo[LeaseBackupRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(leaseId) :: Rep.Some(
      returnId
    ) :: isAnnualRentOver1000 :: breakClauseType :: breakClauseDate :: leaseContReservedRent :: contractEndDate :: contractStartDate :: firstReviewDate :: leaseType :: marketRent :: netPresentValue :: optionToRenew :: totalPremiumPayable :: rentChargeDate :: rentFreePeriod :: reviewClauseType :: rentReviewFrequency :: serviceCharge :: serviceChargeFrequency :: startingRent :: startingRentEndDate :: laterRentKnown :: termsSurrendered :: considToLndlrdBuild :: considToLndlrdContin :: considToLndlrdDebt :: considToLndlrdEmploy :: considToLndlrdOther :: considToLndlrdLand :: considToLndlrdServices :: considToLndlrdSharedQtd :: considToLndlrdSharedUnqtd :: considToTenantBuild :: considToTenantContin :: considToTenantEmploy :: considToTenantOther :: considToTenantLand :: considToTenantServices :: considToTenantSharesQtd :: considToTenantSharesUnqtd :: turnoverRent :: unasertainableRent :: vatAmount :: lMigrated :: Rep
      .Some(createDate) :: Rep.Some(lastUpdateDate) :: HNil).shaped.<>(
      r =>
        LeaseBackupRow(
          r.productElement(0).asInstanceOf[Option[scala.math.BigDecimal]].get,
          r.productElement(1).asInstanceOf[Option[scala.math.BigDecimal]].get,
          r.productElement(2).asInstanceOf[Option[String]],
          r.productElement(3).asInstanceOf[Option[String]],
          r.productElement(4).asInstanceOf[Option[String]],
          r.productElement(5).asInstanceOf[Option[String]],
          r.productElement(6).asInstanceOf[Option[String]],
          r.productElement(7).asInstanceOf[Option[String]],
          r.productElement(8).asInstanceOf[Option[String]],
          r.productElement(9).asInstanceOf[Option[String]],
          r.productElement(10).asInstanceOf[Option[String]],
          r.productElement(11).asInstanceOf[Option[String]],
          r.productElement(12).asInstanceOf[Option[String]],
          r.productElement(13).asInstanceOf[Option[String]],
          r.productElement(14).asInstanceOf[Option[String]],
          r.productElement(15).asInstanceOf[Option[String]],
          r.productElement(16).asInstanceOf[Option[String]],
          r.productElement(17).asInstanceOf[Option[String]],
          r.productElement(18).asInstanceOf[Option[String]],
          r.productElement(19).asInstanceOf[Option[String]],
          r.productElement(20).asInstanceOf[Option[String]],
          r.productElement(21).asInstanceOf[Option[String]],
          r.productElement(22).asInstanceOf[Option[String]],
          r.productElement(23).asInstanceOf[Option[String]],
          r.productElement(24).asInstanceOf[Option[String]],
          r.productElement(25).asInstanceOf[Option[String]],
          r.productElement(26).asInstanceOf[Option[String]],
          r.productElement(27).asInstanceOf[Option[String]],
          r.productElement(28).asInstanceOf[Option[String]],
          r.productElement(29).asInstanceOf[Option[String]],
          r.productElement(30).asInstanceOf[Option[String]],
          r.productElement(31).asInstanceOf[Option[String]],
          r.productElement(32).asInstanceOf[Option[String]],
          r.productElement(33).asInstanceOf[Option[String]],
          r.productElement(34).asInstanceOf[Option[String]],
          r.productElement(35).asInstanceOf[Option[String]],
          r.productElement(36).asInstanceOf[Option[String]],
          r.productElement(37).asInstanceOf[Option[String]],
          r.productElement(38).asInstanceOf[Option[String]],
          r.productElement(39).asInstanceOf[Option[String]],
          r.productElement(40).asInstanceOf[Option[String]],
          r.productElement(41).asInstanceOf[Option[String]],
          r.productElement(42).asInstanceOf[Option[String]],
          r.productElement(43).asInstanceOf[Option[String]],
          r.productElement(44).asInstanceOf[Option[scala.math.BigDecimal]],
          r.productElement(45).asInstanceOf[Option[java.sql.Timestamp]].get,
          r.productElement(46).asInstanceOf[Option[java.sql.Timestamp]].get
        ),
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column LEASE_ID SqlType(NUMBER) */
    val leaseId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("LEASE_ID")

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column IS_ANNUAL_RENT_OVER_1000 SqlType(VARCHAR2), Length(3,true) */
    val isAnnualRentOver1000: Rep[Option[String]] =
      column[Option[String]]("IS_ANNUAL_RENT_OVER_1000", O.Length(3, varying = true))

    /** Database column BREAK_CLAUSE_TYPE SqlType(VARCHAR2), Length(500,true) */
    val breakClauseType: Rep[Option[String]] =
      column[Option[String]]("BREAK_CLAUSE_TYPE", O.Length(500, varying = true))

    /** Database column BREAK_CLAUSE_DATE SqlType(VARCHAR2), Length(500,true) */
    val breakClauseDate: Rep[Option[String]] =
      column[Option[String]]("BREAK_CLAUSE_DATE", O.Length(500, varying = true))

    /** Database column LEASE_CONT_RESERVED_RENT SqlType(VARCHAR2), Length(500,true) */
    val leaseContReservedRent: Rep[Option[String]] =
      column[Option[String]]("LEASE_CONT_RESERVED_RENT", O.Length(500, varying = true))

    /** Database column CONTRACT_END_DATE SqlType(VARCHAR2), Length(500,true) */
    val contractEndDate: Rep[Option[String]] =
      column[Option[String]]("CONTRACT_END_DATE", O.Length(500, varying = true))

    /** Database column CONTRACT_START_DATE SqlType(VARCHAR2), Length(500,true) */
    val contractStartDate: Rep[Option[String]] =
      column[Option[String]]("CONTRACT_START_DATE", O.Length(500, varying = true))

    /** Database column FIRST_REVIEW_DATE SqlType(VARCHAR2), Length(500,true) */
    val firstReviewDate: Rep[Option[String]] =
      column[Option[String]]("FIRST_REVIEW_DATE", O.Length(500, varying = true))

    /** Database column LEASE_TYPE SqlType(VARCHAR2), Length(500,true) */
    val leaseType: Rep[Option[String]] = column[Option[String]]("LEASE_TYPE", O.Length(500, varying = true))

    /** Database column MARKET_RENT SqlType(VARCHAR2), Length(500,true) */
    val marketRent: Rep[Option[String]] = column[Option[String]]("MARKET_RENT", O.Length(500, varying = true))

    /** Database column NET_PRESENT_VALUE SqlType(VARCHAR2), Length(500,true) */
    val netPresentValue: Rep[Option[String]] =
      column[Option[String]]("NET_PRESENT_VALUE", O.Length(500, varying = true))

    /** Database column OPTION_TO_RENEW SqlType(VARCHAR2), Length(500,true) */
    val optionToRenew: Rep[Option[String]] = column[Option[String]]("OPTION_TO_RENEW", O.Length(500, varying = true))

    /** Database column TOTAL_PREMIUM_PAYABLE SqlType(VARCHAR2), Length(500,true) */
    val totalPremiumPayable: Rep[Option[String]] =
      column[Option[String]]("TOTAL_PREMIUM_PAYABLE", O.Length(500, varying = true))

    /** Database column RENT_CHARGE_DATE SqlType(VARCHAR2), Length(500,true) */
    val rentChargeDate: Rep[Option[String]] = column[Option[String]]("RENT_CHARGE_DATE", O.Length(500, varying = true))

    /** Database column RENT_FREE_PERIOD SqlType(VARCHAR2), Length(500,true) */
    val rentFreePeriod: Rep[Option[String]] = column[Option[String]]("RENT_FREE_PERIOD", O.Length(500, varying = true))

    /** Database column REVIEW_CLAUSE_TYPE SqlType(VARCHAR2), Length(500,true) */
    val reviewClauseType: Rep[Option[String]] =
      column[Option[String]]("REVIEW_CLAUSE_TYPE", O.Length(500, varying = true))

    /** Database column RENT_REVIEW_FREQUENCY SqlType(VARCHAR2), Length(500,true) */
    val rentReviewFrequency: Rep[Option[String]] =
      column[Option[String]]("RENT_REVIEW_FREQUENCY", O.Length(500, varying = true))

    /** Database column SERVICE_CHARGE SqlType(VARCHAR2), Length(500,true) */
    val serviceCharge: Rep[Option[String]] = column[Option[String]]("SERVICE_CHARGE", O.Length(500, varying = true))

    /** Database column SERVICE_CHARGE_FREQUENCY SqlType(VARCHAR2), Length(500,true) */
    val serviceChargeFrequency: Rep[Option[String]] =
      column[Option[String]]("SERVICE_CHARGE_FREQUENCY", O.Length(500, varying = true))

    /** Database column STARTING_RENT SqlType(VARCHAR2), Length(500,true) */
    val startingRent: Rep[Option[String]] = column[Option[String]]("STARTING_RENT", O.Length(500, varying = true))

    /** Database column STARTING_RENT_END_DATE SqlType(VARCHAR2), Length(500,true) */
    val startingRentEndDate: Rep[Option[String]] =
      column[Option[String]]("STARTING_RENT_END_DATE", O.Length(500, varying = true))

    /** Database column LATER_RENT_KNOWN SqlType(VARCHAR2), Length(3,true) */
    val laterRentKnown: Rep[Option[String]] = column[Option[String]]("LATER_RENT_KNOWN", O.Length(3, varying = true))

    /** Database column TERMS_SURRENDERED SqlType(VARCHAR2), Length(500,true) */
    val termsSurrendered: Rep[Option[String]] =
      column[Option[String]]("TERMS_SURRENDERED", O.Length(500, varying = true))

    /** Database column CONSID_TO_LNDLRD_BUILD SqlType(VARCHAR2), Length(3,true) */
    val considToLndlrdBuild: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_LNDLRD_BUILD", O.Length(3, varying = true))

    /** Database column CONSID_TO_LNDLRD_CONTIN SqlType(VARCHAR2), Length(3,true) */
    val considToLndlrdContin: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_LNDLRD_CONTIN", O.Length(3, varying = true))

    /** Database column CONSID_TO_LNDLRD_DEBT SqlType(VARCHAR2), Length(3,true) */
    val considToLndlrdDebt: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_LNDLRD_DEBT", O.Length(3, varying = true))

    /** Database column CONSID_TO_LNDLRD_EMPLOY SqlType(VARCHAR2), Length(3,true) */
    val considToLndlrdEmploy: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_LNDLRD_EMPLOY", O.Length(3, varying = true))

    /** Database column CONSID_TO_LNDLRD_OTHER SqlType(VARCHAR2), Length(3,true) */
    val considToLndlrdOther: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_LNDLRD_OTHER", O.Length(3, varying = true))

    /** Database column CONSID_TO_LNDLRD_LAND SqlType(VARCHAR2), Length(3,true) */
    val considToLndlrdLand: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_LNDLRD_LAND", O.Length(3, varying = true))

    /** Database column CONSID_TO_LNDLRD_SERVICES SqlType(VARCHAR2), Length(3,true) */
    val considToLndlrdServices: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_LNDLRD_SERVICES", O.Length(3, varying = true))

    /** Database column CONSID_TO_LNDLRD_SHARED_QTD SqlType(VARCHAR2), Length(3,true) */
    val considToLndlrdSharedQtd: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_LNDLRD_SHARED_QTD", O.Length(3, varying = true))

    /** Database column CONSID_TO_LNDLRD_SHARED_UNQTD SqlType(VARCHAR2), Length(3,true) */
    val considToLndlrdSharedUnqtd: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_LNDLRD_SHARED_UNQTD", O.Length(3, varying = true))

    /** Database column CONSID_TO_TENANT_BUILD SqlType(VARCHAR2), Length(3,true) */
    val considToTenantBuild: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_TENANT_BUILD", O.Length(3, varying = true))

    /** Database column CONSID_TO_TENANT_CONTIN SqlType(VARCHAR2), Length(3,true) */
    val considToTenantContin: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_TENANT_CONTIN", O.Length(3, varying = true))

    /** Database column CONSID_TO_TENANT_EMPLOY SqlType(VARCHAR2), Length(3,true) */
    val considToTenantEmploy: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_TENANT_EMPLOY", O.Length(3, varying = true))

    /** Database column CONSID_TO_TENANT_OTHER SqlType(VARCHAR2), Length(3,true) */
    val considToTenantOther: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_TENANT_OTHER", O.Length(3, varying = true))

    /** Database column CONSID_TO_TENANT_LAND SqlType(VARCHAR2), Length(3,true) */
    val considToTenantLand: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_TENANT_LAND", O.Length(3, varying = true))

    /** Database column CONSID_TO_TENANT_SERVICES SqlType(VARCHAR2), Length(3,true) */
    val considToTenantServices: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_TENANT_SERVICES", O.Length(3, varying = true))

    /** Database column CONSID_TO_TENANT_SHARES_QTD SqlType(VARCHAR2), Length(3,true) */
    val considToTenantSharesQtd: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_TENANT_SHARES_QTD", O.Length(3, varying = true))

    /** Database column CONSID_TO_TENANT_SHARES_UNQTD SqlType(VARCHAR2), Length(3,true) */
    val considToTenantSharesUnqtd: Rep[Option[String]] =
      column[Option[String]]("CONSID_TO_TENANT_SHARES_UNQTD", O.Length(3, varying = true))

    /** Database column TURNOVER_RENT SqlType(VARCHAR2), Length(500,true) */
    val turnoverRent: Rep[Option[String]] = column[Option[String]]("TURNOVER_RENT", O.Length(500, varying = true))

    /** Database column UNASERTAINABLE_RENT SqlType(VARCHAR2), Length(500,true) */
    val unasertainableRent: Rep[Option[String]] =
      column[Option[String]]("UNASERTAINABLE_RENT", O.Length(500, varying = true))

    /** Database column VAT_AMOUNT SqlType(VARCHAR2), Length(500,true) */
    val vatAmount: Rep[Option[String]] = column[Option[String]]("VAT_AMOUNT", O.Length(500, varying = true))

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")
  }

  /** Collection-like TableQuery object for table LeaseBackup */
  lazy val LeaseBackup = new TableQuery(tag => new LeaseBackup(tag))

  /** Entity class storing rows of table PreventMessageAudit
    * @param storn
    *   Database column STORN SqlType(VARCHAR2), Length(10,true)
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param groupingReference
    *   Database column GROUPING_REFERENCE SqlType(VARCHAR2), Length(255,true)
    * @param messageReference
    *   Database column MESSAGE_REFERENCE SqlType(VARCHAR2), Length(255,true)
    * @param viewCount
    *   Database column VIEW_COUNT SqlType(NUMBER)
    * @param datetime
    *   Database column DATETIME SqlType(TIMESTAMP(6))
    */
  case class PreventMessageAuditRow(
    storn: String,
    returnId: scala.math.BigDecimal,
    groupingReference: String,
    messageReference: String,
    viewCount: Option[scala.math.BigDecimal],
    datetime: Option[java.sql.Timestamp]
  )

  /** GetResult implicit for fetching PreventMessageAuditRow objects using plain SQL queries */
  implicit def GetResultPreventMessageAuditRow(implicit
    e0: GR[String],
    e1: GR[scala.math.BigDecimal],
    e2: GR[Option[scala.math.BigDecimal]],
    e3: GR[Option[java.sql.Timestamp]]
  ): GR[PreventMessageAuditRow] = GR { prs =>
    import prs._
    (PreventMessageAuditRow.apply _).tupled(
      (
        <<[String],
        <<[scala.math.BigDecimal],
        <<[String],
        <<[String],
        <<?[scala.math.BigDecimal],
        <<?[java.sql.Timestamp]
      )
    )
  }

  /** Table description of table PREVENT_MESSAGE_AUDIT. Objects of this class serve as prototypes for rows in queries.
    */
  class PreventMessageAudit(_tableTag: Tag)
      extends profile.api.Table[PreventMessageAuditRow](_tableTag, Some("SDLT_FILE_DATA"), "PREVENT_MESSAGE_AUDIT") {
    def * = ((storn, returnId, groupingReference, messageReference, viewCount, datetime)).mapTo[PreventMessageAuditRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(storn),
        Rep.Some(returnId),
        Rep.Some(groupingReference),
        Rep.Some(messageReference),
        viewCount,
        datetime
      )
    ).shaped.<>(
      { r =>
        import r._; _1.map(_ => (PreventMessageAuditRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5, _6)))
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column STORN SqlType(VARCHAR2), Length(10,true) */
    val storn: Rep[String] = column[String]("STORN", O.Length(10, varying = true))

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column GROUPING_REFERENCE SqlType(VARCHAR2), Length(255,true) */
    val groupingReference: Rep[String] = column[String]("GROUPING_REFERENCE", O.Length(255, varying = true))

    /** Database column MESSAGE_REFERENCE SqlType(VARCHAR2), Length(255,true) */
    val messageReference: Rep[String] = column[String]("MESSAGE_REFERENCE", O.Length(255, varying = true))

    /** Database column VIEW_COUNT SqlType(NUMBER) */
    val viewCount: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("VIEW_COUNT")

    /** Database column DATETIME SqlType(TIMESTAMP(6)) */
    val datetime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("DATETIME")

    /** Primary key of PreventMessageAudit (database name PREVENT_MESSAGE_AUDIT_PK) */
    val pk = primaryKey("PREVENT_MESSAGE_AUDIT_PK", (storn, returnId, groupingReference, messageReference))
  }

  /** Collection-like TableQuery object for table PreventMessageAudit */
  lazy val PreventMessageAudit = new TableQuery(tag => new PreventMessageAudit(tag))

  /** Entity class storing rows of table Purchaser
    * @param purchaserId
    *   Database column PURCHASER_ID SqlType(NUMBER), PrimaryKey
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param isCompany
    *   Database column IS_COMPANY SqlType(VARCHAR2), Length(3,true)
    * @param isTrustee
    *   Database column IS_TRUSTEE SqlType(VARCHAR2), Length(3,true)
    * @param isConnectedToVendor
    *   Database column IS_CONNECTED_TO_VENDOR SqlType(VARCHAR2), Length(3,true)
    * @param isRepresentedByAgent
    *   Database column IS_REPRESENTED_BY_AGENT SqlType(VARCHAR2), Length(3,true)
    * @param title
    *   Database column TITLE SqlType(VARCHAR2), Length(500,true)
    * @param surname
    *   Database column SURNAME SqlType(VARCHAR2), Length(500,true)
    * @param forename1
    *   Database column FORENAME1 SqlType(VARCHAR2), Length(500,true)
    * @param forename2
    *   Database column FORENAME2 SqlType(VARCHAR2), Length(500,true)
    * @param companyName
    *   Database column COMPANY_NAME SqlType(VARCHAR2), Length(500,true)
    * @param houseNumber
    *   Database column HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param address1
    *   Database column ADDRESS_1 SqlType(VARCHAR2), Length(500,true)
    * @param address2
    *   Database column ADDRESS_2 SqlType(VARCHAR2), Length(500,true)
    * @param address3
    *   Database column ADDRESS_3 SqlType(VARCHAR2), Length(500,true)
    * @param address4
    *   Database column ADDRESS_4 SqlType(VARCHAR2), Length(500,true)
    * @param postcode
    *   Database column POSTCODE SqlType(VARCHAR2), Length(500,true)
    * @param phone
    *   Database column PHONE SqlType(VARCHAR2), Length(500,true)
    * @param nino
    *   Database column NINO SqlType(VARCHAR2), Length(500,true)
    * @param purchaserResourceRef
    *   Database column PURCHASER_RESOURCE_REF SqlType(NUMBER)
    * @param nextPurchaserId
    *   Database column NEXT_PURCHASER_ID SqlType(NUMBER)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    * @param hasNino
    *   Database column HAS_NINO SqlType(VARCHAR2), Length(3,true)
    * @param dateOfBirth
    *   Database column DATE_OF_BIRTH SqlType(VARCHAR2), Length(500,true)
    * @param isUkCompany
    *   Database column IS_UK_COMPANY SqlType(VARCHAR2), Length(3,true)
    * @param registrationNumber
    *   Database column REGISTRATION_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param placeOfRegistration
    *   Database column PLACE_OF_REGISTRATION SqlType(VARCHAR2), Length(500,true)
    */
  case class PurchaserRow(
    purchaserId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    isCompany: Option[String],
    isTrustee: Option[String],
    isConnectedToVendor: Option[String],
    isRepresentedByAgent: Option[String],
    title: Option[String],
    surname: Option[String],
    forename1: Option[String],
    forename2: Option[String],
    companyName: Option[String],
    houseNumber: Option[String],
    address1: Option[String],
    address2: Option[String],
    address3: Option[String],
    address4: Option[String],
    postcode: Option[String],
    phone: Option[String],
    nino: Option[String],
    purchaserResourceRef: Option[scala.math.BigDecimal],
    nextPurchaserId: Option[scala.math.BigDecimal],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp,
    hasNino: Option[String],
    dateOfBirth: Option[String],
    isUkCompany: Option[String],
    registrationNumber: Option[String],
    placeOfRegistration: Option[String]
  )

  /** GetResult implicit for fetching PurchaserRow objects using plain SQL queries */
  implicit def GetResultPurchaserRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[String]],
    e2: GR[Option[scala.math.BigDecimal]],
    e3: GR[java.sql.Timestamp]
  ): GR[PurchaserRow] = GR { prs =>
    import prs._
    PurchaserRow(
      <<[scala.math.BigDecimal],
      <<[scala.math.BigDecimal],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[scala.math.BigDecimal],
      <<?[scala.math.BigDecimal],
      <<?[scala.math.BigDecimal],
      <<[java.sql.Timestamp],
      <<[java.sql.Timestamp],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String]
    )
  }

  /** Table description of table PURCHASER. Objects of this class serve as prototypes for rows in queries. */
  class Purchaser(_tableTag: Tag)
      extends profile.api.Table[PurchaserRow](_tableTag, Some("SDLT_FILE_DATA"), "PURCHASER") {
    def * =
      (purchaserId :: returnId :: isCompany :: isTrustee :: isConnectedToVendor :: isRepresentedByAgent :: title :: surname :: forename1 :: forename2 :: companyName :: houseNumber :: address1 :: address2 :: address3 :: address4 :: postcode :: phone :: nino :: purchaserResourceRef :: nextPurchaserId :: lMigrated :: createDate :: lastUpdateDate :: hasNino :: dateOfBirth :: isUkCompany :: registrationNumber :: placeOfRegistration :: HNil)
        .mapTo[PurchaserRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(purchaserId) :: Rep.Some(
      returnId
    ) :: isCompany :: isTrustee :: isConnectedToVendor :: isRepresentedByAgent :: title :: surname :: forename1 :: forename2 :: companyName :: houseNumber :: address1 :: address2 :: address3 :: address4 :: postcode :: phone :: nino :: purchaserResourceRef :: nextPurchaserId :: lMigrated :: Rep
      .Some(createDate) :: Rep.Some(
      lastUpdateDate
    ) :: hasNino :: dateOfBirth :: isUkCompany :: registrationNumber :: placeOfRegistration :: HNil).shaped.<>(
      r =>
        PurchaserRow(
          r.productElement(0).asInstanceOf[Option[scala.math.BigDecimal]].get,
          r.productElement(1).asInstanceOf[Option[scala.math.BigDecimal]].get,
          r.productElement(2).asInstanceOf[Option[String]],
          r.productElement(3).asInstanceOf[Option[String]],
          r.productElement(4).asInstanceOf[Option[String]],
          r.productElement(5).asInstanceOf[Option[String]],
          r.productElement(6).asInstanceOf[Option[String]],
          r.productElement(7).asInstanceOf[Option[String]],
          r.productElement(8).asInstanceOf[Option[String]],
          r.productElement(9).asInstanceOf[Option[String]],
          r.productElement(10).asInstanceOf[Option[String]],
          r.productElement(11).asInstanceOf[Option[String]],
          r.productElement(12).asInstanceOf[Option[String]],
          r.productElement(13).asInstanceOf[Option[String]],
          r.productElement(14).asInstanceOf[Option[String]],
          r.productElement(15).asInstanceOf[Option[String]],
          r.productElement(16).asInstanceOf[Option[String]],
          r.productElement(17).asInstanceOf[Option[String]],
          r.productElement(18).asInstanceOf[Option[String]],
          r.productElement(19).asInstanceOf[Option[scala.math.BigDecimal]],
          r.productElement(20).asInstanceOf[Option[scala.math.BigDecimal]],
          r.productElement(21).asInstanceOf[Option[scala.math.BigDecimal]],
          r.productElement(22).asInstanceOf[Option[java.sql.Timestamp]].get,
          r.productElement(23).asInstanceOf[Option[java.sql.Timestamp]].get,
          r.productElement(24).asInstanceOf[Option[String]],
          r.productElement(25).asInstanceOf[Option[String]],
          r.productElement(26).asInstanceOf[Option[String]],
          r.productElement(27).asInstanceOf[Option[String]],
          r.productElement(28).asInstanceOf[Option[String]]
        ),
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column PURCHASER_ID SqlType(NUMBER), PrimaryKey */
    val purchaserId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("PURCHASER_ID", O.PrimaryKey)

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column IS_COMPANY SqlType(VARCHAR2), Length(3,true) */
    val isCompany: Rep[Option[String]] = column[Option[String]]("IS_COMPANY", O.Length(3, varying = true))

    /** Database column IS_TRUSTEE SqlType(VARCHAR2), Length(3,true) */
    val isTrustee: Rep[Option[String]] = column[Option[String]]("IS_TRUSTEE", O.Length(3, varying = true))

    /** Database column IS_CONNECTED_TO_VENDOR SqlType(VARCHAR2), Length(3,true) */
    val isConnectedToVendor: Rep[Option[String]] =
      column[Option[String]]("IS_CONNECTED_TO_VENDOR", O.Length(3, varying = true))

    /** Database column IS_REPRESENTED_BY_AGENT SqlType(VARCHAR2), Length(3,true) */
    val isRepresentedByAgent: Rep[Option[String]] =
      column[Option[String]]("IS_REPRESENTED_BY_AGENT", O.Length(3, varying = true))

    /** Database column TITLE SqlType(VARCHAR2), Length(500,true) */
    val title: Rep[Option[String]] = column[Option[String]]("TITLE", O.Length(500, varying = true))

    /** Database column SURNAME SqlType(VARCHAR2), Length(500,true) */
    val surname: Rep[Option[String]] = column[Option[String]]("SURNAME", O.Length(500, varying = true))

    /** Database column FORENAME1 SqlType(VARCHAR2), Length(500,true) */
    val forename1: Rep[Option[String]] = column[Option[String]]("FORENAME1", O.Length(500, varying = true))

    /** Database column FORENAME2 SqlType(VARCHAR2), Length(500,true) */
    val forename2: Rep[Option[String]] = column[Option[String]]("FORENAME2", O.Length(500, varying = true))

    /** Database column COMPANY_NAME SqlType(VARCHAR2), Length(500,true) */
    val companyName: Rep[Option[String]] = column[Option[String]]("COMPANY_NAME", O.Length(500, varying = true))

    /** Database column HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val houseNumber: Rep[Option[String]] = column[Option[String]]("HOUSE_NUMBER", O.Length(500, varying = true))

    /** Database column ADDRESS_1 SqlType(VARCHAR2), Length(500,true) */
    val address1: Rep[Option[String]] = column[Option[String]]("ADDRESS_1", O.Length(500, varying = true))

    /** Database column ADDRESS_2 SqlType(VARCHAR2), Length(500,true) */
    val address2: Rep[Option[String]] = column[Option[String]]("ADDRESS_2", O.Length(500, varying = true))

    /** Database column ADDRESS_3 SqlType(VARCHAR2), Length(500,true) */
    val address3: Rep[Option[String]] = column[Option[String]]("ADDRESS_3", O.Length(500, varying = true))

    /** Database column ADDRESS_4 SqlType(VARCHAR2), Length(500,true) */
    val address4: Rep[Option[String]] = column[Option[String]]("ADDRESS_4", O.Length(500, varying = true))

    /** Database column POSTCODE SqlType(VARCHAR2), Length(500,true) */
    val postcode: Rep[Option[String]] = column[Option[String]]("POSTCODE", O.Length(500, varying = true))

    /** Database column PHONE SqlType(VARCHAR2), Length(500,true) */
    val phone: Rep[Option[String]] = column[Option[String]]("PHONE", O.Length(500, varying = true))

    /** Database column NINO SqlType(VARCHAR2), Length(500,true) */
    val nino: Rep[Option[String]] = column[Option[String]]("NINO", O.Length(500, varying = true))

    /** Database column PURCHASER_RESOURCE_REF SqlType(NUMBER) */
    val purchaserResourceRef: Rep[Option[scala.math.BigDecimal]] =
      column[Option[scala.math.BigDecimal]]("PURCHASER_RESOURCE_REF")

    /** Database column NEXT_PURCHASER_ID SqlType(NUMBER) */
    val nextPurchaserId: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("NEXT_PURCHASER_ID")

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")

    /** Database column HAS_NINO SqlType(VARCHAR2), Length(3,true) */
    val hasNino: Rep[Option[String]] = column[Option[String]]("HAS_NINO", O.Length(3, varying = true))

    /** Database column DATE_OF_BIRTH SqlType(VARCHAR2), Length(500,true) */
    val dateOfBirth: Rep[Option[String]] = column[Option[String]]("DATE_OF_BIRTH", O.Length(500, varying = true))

    /** Database column IS_UK_COMPANY SqlType(VARCHAR2), Length(3,true) */
    val isUkCompany: Rep[Option[String]] = column[Option[String]]("IS_UK_COMPANY", O.Length(3, varying = true))

    /** Database column REGISTRATION_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val registrationNumber: Rep[Option[String]] =
      column[Option[String]]("REGISTRATION_NUMBER", O.Length(500, varying = true))

    /** Database column PLACE_OF_REGISTRATION SqlType(VARCHAR2), Length(500,true) */
    val placeOfRegistration: Rep[Option[String]] =
      column[Option[String]]("PLACE_OF_REGISTRATION", O.Length(500, varying = true))

    /** Foreign key referencing Purchaser (database name PURCHASER_PURCHASER_FK) */
    lazy val purchaserFk = foreignKey("PURCHASER_PURCHASER_FK", nextPurchaserId :: HNil, Purchaser)(
      r => Rep.Some(r.purchaserId) :: HNil,
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )

    /** Foreign key referencing Return (database name PURCHASER_RETURN_FK) */
    lazy val returnFk = foreignKey("PURCHASER_RETURN_FK", returnId :: HNil, Return)(
      r => r.returnId :: HNil,
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )
  }

  /** Collection-like TableQuery object for table Purchaser */
  lazy val Purchaser = new TableQuery(tag => new Purchaser(tag))

  /** Entity class storing rows of table PurchaserBackup
    * @param purchaserId
    *   Database column PURCHASER_ID SqlType(NUMBER)
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param isCompany
    *   Database column IS_COMPANY SqlType(VARCHAR2), Length(3,true)
    * @param isTrustee
    *   Database column IS_TRUSTEE SqlType(VARCHAR2), Length(3,true)
    * @param isConnectedToVendor
    *   Database column IS_CONNECTED_TO_VENDOR SqlType(VARCHAR2), Length(3,true)
    * @param isRepresentedByAgent
    *   Database column IS_REPRESENTED_BY_AGENT SqlType(VARCHAR2), Length(3,true)
    * @param title
    *   Database column TITLE SqlType(VARCHAR2), Length(500,true)
    * @param surname
    *   Database column SURNAME SqlType(VARCHAR2), Length(500,true)
    * @param forename1
    *   Database column FORENAME1 SqlType(VARCHAR2), Length(500,true)
    * @param forename2
    *   Database column FORENAME2 SqlType(VARCHAR2), Length(500,true)
    * @param companyName
    *   Database column COMPANY_NAME SqlType(VARCHAR2), Length(500,true)
    * @param houseNumber
    *   Database column HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param address1
    *   Database column ADDRESS_1 SqlType(VARCHAR2), Length(500,true)
    * @param address2
    *   Database column ADDRESS_2 SqlType(VARCHAR2), Length(500,true)
    * @param address3
    *   Database column ADDRESS_3 SqlType(VARCHAR2), Length(500,true)
    * @param address4
    *   Database column ADDRESS_4 SqlType(VARCHAR2), Length(500,true)
    * @param postcode
    *   Database column POSTCODE SqlType(VARCHAR2), Length(500,true)
    * @param phone
    *   Database column PHONE SqlType(VARCHAR2), Length(500,true)
    * @param nino
    *   Database column NINO SqlType(VARCHAR2), Length(500,true)
    * @param purchaserResourceRef
    *   Database column PURCHASER_RESOURCE_REF SqlType(NUMBER)
    * @param nextPurchaserId
    *   Database column NEXT_PURCHASER_ID SqlType(NUMBER)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    * @param hasNino
    *   Database column HAS_NINO SqlType(VARCHAR2), Length(3,true)
    * @param dateOfBirth
    *   Database column DATE_OF_BIRTH SqlType(VARCHAR2), Length(500,true)
    * @param isUkCompany
    *   Database column IS_UK_COMPANY SqlType(VARCHAR2), Length(3,true)
    * @param registrationNumber
    *   Database column REGISTRATION_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param placeOfRegistration
    *   Database column PLACE_OF_REGISTRATION SqlType(VARCHAR2), Length(500,true)
    */
  case class PurchaserBackupRow(
    purchaserId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    isCompany: Option[String],
    isTrustee: Option[String],
    isConnectedToVendor: Option[String],
    isRepresentedByAgent: Option[String],
    title: Option[String],
    surname: Option[String],
    forename1: Option[String],
    forename2: Option[String],
    companyName: Option[String],
    houseNumber: Option[String],
    address1: Option[String],
    address2: Option[String],
    address3: Option[String],
    address4: Option[String],
    postcode: Option[String],
    phone: Option[String],
    nino: Option[String],
    purchaserResourceRef: Option[scala.math.BigDecimal],
    nextPurchaserId: Option[scala.math.BigDecimal],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp,
    hasNino: Option[String],
    dateOfBirth: Option[String],
    isUkCompany: Option[String],
    registrationNumber: Option[String],
    placeOfRegistration: Option[String]
  )

  /** GetResult implicit for fetching PurchaserBackupRow objects using plain SQL queries */
  implicit def GetResultPurchaserBackupRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[String]],
    e2: GR[Option[scala.math.BigDecimal]],
    e3: GR[java.sql.Timestamp]
  ): GR[PurchaserBackupRow] = GR { prs =>
    import prs._
    PurchaserBackupRow(
      <<[scala.math.BigDecimal],
      <<[scala.math.BigDecimal],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[scala.math.BigDecimal],
      <<?[scala.math.BigDecimal],
      <<?[scala.math.BigDecimal],
      <<[java.sql.Timestamp],
      <<[java.sql.Timestamp],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String]
    )
  }

  /** Table description of table PURCHASER_BACKUP. Objects of this class serve as prototypes for rows in queries. */
  class PurchaserBackup(_tableTag: Tag)
      extends profile.api.Table[PurchaserBackupRow](_tableTag, Some("SDLT_FILE_DATA"), "PURCHASER_BACKUP") {
    def * =
      (purchaserId :: returnId :: isCompany :: isTrustee :: isConnectedToVendor :: isRepresentedByAgent :: title :: surname :: forename1 :: forename2 :: companyName :: houseNumber :: address1 :: address2 :: address3 :: address4 :: postcode :: phone :: nino :: purchaserResourceRef :: nextPurchaserId :: lMigrated :: createDate :: lastUpdateDate :: hasNino :: dateOfBirth :: isUkCompany :: registrationNumber :: placeOfRegistration :: HNil)
        .mapTo[PurchaserBackupRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(purchaserId) :: Rep.Some(
      returnId
    ) :: isCompany :: isTrustee :: isConnectedToVendor :: isRepresentedByAgent :: title :: surname :: forename1 :: forename2 :: companyName :: houseNumber :: address1 :: address2 :: address3 :: address4 :: postcode :: phone :: nino :: purchaserResourceRef :: nextPurchaserId :: lMigrated :: Rep
      .Some(createDate) :: Rep.Some(
      lastUpdateDate
    ) :: hasNino :: dateOfBirth :: isUkCompany :: registrationNumber :: placeOfRegistration :: HNil).shaped.<>(
      r =>
        PurchaserBackupRow(
          r.productElement(0).asInstanceOf[Option[scala.math.BigDecimal]].get,
          r.productElement(1).asInstanceOf[Option[scala.math.BigDecimal]].get,
          r.productElement(2).asInstanceOf[Option[String]],
          r.productElement(3).asInstanceOf[Option[String]],
          r.productElement(4).asInstanceOf[Option[String]],
          r.productElement(5).asInstanceOf[Option[String]],
          r.productElement(6).asInstanceOf[Option[String]],
          r.productElement(7).asInstanceOf[Option[String]],
          r.productElement(8).asInstanceOf[Option[String]],
          r.productElement(9).asInstanceOf[Option[String]],
          r.productElement(10).asInstanceOf[Option[String]],
          r.productElement(11).asInstanceOf[Option[String]],
          r.productElement(12).asInstanceOf[Option[String]],
          r.productElement(13).asInstanceOf[Option[String]],
          r.productElement(14).asInstanceOf[Option[String]],
          r.productElement(15).asInstanceOf[Option[String]],
          r.productElement(16).asInstanceOf[Option[String]],
          r.productElement(17).asInstanceOf[Option[String]],
          r.productElement(18).asInstanceOf[Option[String]],
          r.productElement(19).asInstanceOf[Option[scala.math.BigDecimal]],
          r.productElement(20).asInstanceOf[Option[scala.math.BigDecimal]],
          r.productElement(21).asInstanceOf[Option[scala.math.BigDecimal]],
          r.productElement(22).asInstanceOf[Option[java.sql.Timestamp]].get,
          r.productElement(23).asInstanceOf[Option[java.sql.Timestamp]].get,
          r.productElement(24).asInstanceOf[Option[String]],
          r.productElement(25).asInstanceOf[Option[String]],
          r.productElement(26).asInstanceOf[Option[String]],
          r.productElement(27).asInstanceOf[Option[String]],
          r.productElement(28).asInstanceOf[Option[String]]
        ),
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column PURCHASER_ID SqlType(NUMBER) */
    val purchaserId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("PURCHASER_ID")

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column IS_COMPANY SqlType(VARCHAR2), Length(3,true) */
    val isCompany: Rep[Option[String]] = column[Option[String]]("IS_COMPANY", O.Length(3, varying = true))

    /** Database column IS_TRUSTEE SqlType(VARCHAR2), Length(3,true) */
    val isTrustee: Rep[Option[String]] = column[Option[String]]("IS_TRUSTEE", O.Length(3, varying = true))

    /** Database column IS_CONNECTED_TO_VENDOR SqlType(VARCHAR2), Length(3,true) */
    val isConnectedToVendor: Rep[Option[String]] =
      column[Option[String]]("IS_CONNECTED_TO_VENDOR", O.Length(3, varying = true))

    /** Database column IS_REPRESENTED_BY_AGENT SqlType(VARCHAR2), Length(3,true) */
    val isRepresentedByAgent: Rep[Option[String]] =
      column[Option[String]]("IS_REPRESENTED_BY_AGENT", O.Length(3, varying = true))

    /** Database column TITLE SqlType(VARCHAR2), Length(500,true) */
    val title: Rep[Option[String]] = column[Option[String]]("TITLE", O.Length(500, varying = true))

    /** Database column SURNAME SqlType(VARCHAR2), Length(500,true) */
    val surname: Rep[Option[String]] = column[Option[String]]("SURNAME", O.Length(500, varying = true))

    /** Database column FORENAME1 SqlType(VARCHAR2), Length(500,true) */
    val forename1: Rep[Option[String]] = column[Option[String]]("FORENAME1", O.Length(500, varying = true))

    /** Database column FORENAME2 SqlType(VARCHAR2), Length(500,true) */
    val forename2: Rep[Option[String]] = column[Option[String]]("FORENAME2", O.Length(500, varying = true))

    /** Database column COMPANY_NAME SqlType(VARCHAR2), Length(500,true) */
    val companyName: Rep[Option[String]] = column[Option[String]]("COMPANY_NAME", O.Length(500, varying = true))

    /** Database column HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val houseNumber: Rep[Option[String]] = column[Option[String]]("HOUSE_NUMBER", O.Length(500, varying = true))

    /** Database column ADDRESS_1 SqlType(VARCHAR2), Length(500,true) */
    val address1: Rep[Option[String]] = column[Option[String]]("ADDRESS_1", O.Length(500, varying = true))

    /** Database column ADDRESS_2 SqlType(VARCHAR2), Length(500,true) */
    val address2: Rep[Option[String]] = column[Option[String]]("ADDRESS_2", O.Length(500, varying = true))

    /** Database column ADDRESS_3 SqlType(VARCHAR2), Length(500,true) */
    val address3: Rep[Option[String]] = column[Option[String]]("ADDRESS_3", O.Length(500, varying = true))

    /** Database column ADDRESS_4 SqlType(VARCHAR2), Length(500,true) */
    val address4: Rep[Option[String]] = column[Option[String]]("ADDRESS_4", O.Length(500, varying = true))

    /** Database column POSTCODE SqlType(VARCHAR2), Length(500,true) */
    val postcode: Rep[Option[String]] = column[Option[String]]("POSTCODE", O.Length(500, varying = true))

    /** Database column PHONE SqlType(VARCHAR2), Length(500,true) */
    val phone: Rep[Option[String]] = column[Option[String]]("PHONE", O.Length(500, varying = true))

    /** Database column NINO SqlType(VARCHAR2), Length(500,true) */
    val nino: Rep[Option[String]] = column[Option[String]]("NINO", O.Length(500, varying = true))

    /** Database column PURCHASER_RESOURCE_REF SqlType(NUMBER) */
    val purchaserResourceRef: Rep[Option[scala.math.BigDecimal]] =
      column[Option[scala.math.BigDecimal]]("PURCHASER_RESOURCE_REF")

    /** Database column NEXT_PURCHASER_ID SqlType(NUMBER) */
    val nextPurchaserId: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("NEXT_PURCHASER_ID")

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")

    /** Database column HAS_NINO SqlType(VARCHAR2), Length(3,true) */
    val hasNino: Rep[Option[String]] = column[Option[String]]("HAS_NINO", O.Length(3, varying = true))

    /** Database column DATE_OF_BIRTH SqlType(VARCHAR2), Length(500,true) */
    val dateOfBirth: Rep[Option[String]] = column[Option[String]]("DATE_OF_BIRTH", O.Length(500, varying = true))

    /** Database column IS_UK_COMPANY SqlType(VARCHAR2), Length(3,true) */
    val isUkCompany: Rep[Option[String]] = column[Option[String]]("IS_UK_COMPANY", O.Length(3, varying = true))

    /** Database column REGISTRATION_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val registrationNumber: Rep[Option[String]] =
      column[Option[String]]("REGISTRATION_NUMBER", O.Length(500, varying = true))

    /** Database column PLACE_OF_REGISTRATION SqlType(VARCHAR2), Length(500,true) */
    val placeOfRegistration: Rep[Option[String]] =
      column[Option[String]]("PLACE_OF_REGISTRATION", O.Length(500, varying = true))
  }

  /** Collection-like TableQuery object for table PurchaserBackup */
  lazy val PurchaserBackup = new TableQuery(tag => new PurchaserBackup(tag))

  /** Entity class storing rows of table Residency
    * @param residencyId
    *   Database column RESIDENCY_ID SqlType(NUMBER), PrimaryKey
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param isNonUkResidents
    *   Database column IS_NON_UK_RESIDENTS SqlType(VARCHAR2), Length(3,true)
    * @param isCloseCompany
    *   Database column IS_CLOSE_COMPANY SqlType(VARCHAR2), Length(3,true)
    * @param isCrownRelief
    *   Database column IS_CROWN_RELIEF SqlType(VARCHAR2), Length(3,true)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    */
  case class ResidencyRow(
    residencyId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    isNonUkResidents: Option[String],
    isCloseCompany: Option[String],
    isCrownRelief: Option[String],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp
  )

  /** GetResult implicit for fetching ResidencyRow objects using plain SQL queries */
  implicit def GetResultResidencyRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[String]],
    e2: GR[Option[scala.math.BigDecimal]],
    e3: GR[java.sql.Timestamp]
  ): GR[ResidencyRow] = GR { prs =>
    import prs._
    (ResidencyRow.apply _).tupled(
      (
        <<[scala.math.BigDecimal],
        <<[scala.math.BigDecimal],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[scala.math.BigDecimal],
        <<[java.sql.Timestamp],
        <<[java.sql.Timestamp]
      )
    )
  }

  /** Table description of table RESIDENCY. Objects of this class serve as prototypes for rows in queries. */
  class Residency(_tableTag: Tag)
      extends profile.api.Table[ResidencyRow](_tableTag, Some("SDLT_FILE_DATA"), "RESIDENCY") {
    def * =
      ((residencyId, returnId, isNonUkResidents, isCloseCompany, isCrownRelief, lMigrated, createDate, lastUpdateDate))
        .mapTo[ResidencyRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(residencyId),
        Rep.Some(returnId),
        isNonUkResidents,
        isCloseCompany,
        isCrownRelief,
        lMigrated,
        Rep.Some(createDate),
        Rep.Some(lastUpdateDate)
      )
    ).shaped.<>(
      { r =>
        import r._; _1.map(_ => (ResidencyRow.apply _).tupled((_1.get, _2.get, _3, _4, _5, _6, _7.get, _8.get)))
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column RESIDENCY_ID SqlType(NUMBER), PrimaryKey */
    val residencyId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RESIDENCY_ID", O.PrimaryKey)

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column IS_NON_UK_RESIDENTS SqlType(VARCHAR2), Length(3,true) */
    val isNonUkResidents: Rep[Option[String]] =
      column[Option[String]]("IS_NON_UK_RESIDENTS", O.Length(3, varying = true))

    /** Database column IS_CLOSE_COMPANY SqlType(VARCHAR2), Length(3,true) */
    val isCloseCompany: Rep[Option[String]] = column[Option[String]]("IS_CLOSE_COMPANY", O.Length(3, varying = true))

    /** Database column IS_CROWN_RELIEF SqlType(VARCHAR2), Length(3,true) */
    val isCrownRelief: Rep[Option[String]] = column[Option[String]]("IS_CROWN_RELIEF", O.Length(3, varying = true))

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")

    /** Foreign key referencing Return (database name RESIDENCY_RETURN_FK) */
    lazy val returnFk = foreignKey("RESIDENCY_RETURN_FK", returnId, Return)(
      r => r.returnId,
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )
  }

  /** Collection-like TableQuery object for table Residency */
  lazy val Residency = new TableQuery(tag => new Residency(tag))

  /** Entity class storing rows of table Return
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER), PrimaryKey
    * @param storn
    *   Database column STORN SqlType(VARCHAR2), Length(10,true)
    * @param purchaserCounter
    *   Database column PURCHASER_COUNTER SqlType(NUMBER)
    * @param vendorCounter
    *   Database column VENDOR_COUNTER SqlType(NUMBER)
    * @param landCounter
    *   Database column LAND_COUNTER SqlType(NUMBER)
    * @param version
    *   Database column VERSION SqlType(NUMBER)
    * @param mainPurchaserId
    *   Database column MAIN_PURCHASER_ID SqlType(NUMBER)
    * @param mainVendorId
    *   Database column MAIN_VENDOR_ID SqlType(NUMBER)
    * @param mainLandId
    *   Database column MAIN_LAND_ID SqlType(NUMBER)
    * @param irmarkGenerated
    *   Database column IRMARK_GENERATED SqlType(VARCHAR2), Length(255,true)
    * @param landCertForEachProp
    *   Database column LAND_CERT_FOR_EACH_PROP SqlType(VARCHAR2), Length(3,true)
    * @param purgeDate
    *   Database column PURGE_DATE SqlType(DATE)
    * @param returnResourceRef
    *   Database column RETURN_RESOURCE_REF SqlType(NUMBER)
    * @param status
    *   Database column STATUS SqlType(VARCHAR2), Length(20,true)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    * @param declaration
    *   Database column DECLARATION SqlType(VARCHAR2), Length(20,true)
    */
  case class ReturnRow(
    returnId: scala.math.BigDecimal,
    storn: String,
    purchaserCounter: scala.math.BigDecimal,
    vendorCounter: scala.math.BigDecimal,
    landCounter: scala.math.BigDecimal,
    version: Option[scala.math.BigDecimal],
    mainPurchaserId: Option[scala.math.BigDecimal],
    mainVendorId: Option[scala.math.BigDecimal],
    mainLandId: Option[scala.math.BigDecimal],
    irmarkGenerated: Option[String],
    landCertForEachProp: Option[String],
    purgeDate: Option[java.sql.Timestamp],
    returnResourceRef: Option[scala.math.BigDecimal],
    status: String,
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp,
    declaration: Option[String]
  )

  /** GetResult implicit for fetching ReturnRow objects using plain SQL queries */
  implicit def GetResultReturnRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[String],
    e2: GR[Option[scala.math.BigDecimal]],
    e3: GR[Option[String]],
    e4: GR[Option[java.sql.Timestamp]],
    e5: GR[java.sql.Timestamp]
  ): GR[ReturnRow] = GR { prs =>
    import prs._
    (ReturnRow.apply _).tupled(
      (
        <<[scala.math.BigDecimal],
        <<[String],
        <<[scala.math.BigDecimal],
        <<[scala.math.BigDecimal],
        <<[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[String],
        <<?[String],
        <<?[java.sql.Timestamp],
        <<?[scala.math.BigDecimal],
        <<[String],
        <<?[scala.math.BigDecimal],
        <<[java.sql.Timestamp],
        <<[java.sql.Timestamp],
        <<?[String]
      )
    )
  }

  /** Table description of table RETURN. Objects of this class serve as prototypes for rows in queries. */
  class Return(_tableTag: Tag) extends profile.api.Table[ReturnRow](_tableTag, Some("SDLT_FILE_DATA"), "RETURN") {
    def * = (
      (
        returnId,
        storn,
        purchaserCounter,
        vendorCounter,
        landCounter,
        version,
        mainPurchaserId,
        mainVendorId,
        mainLandId,
        irmarkGenerated,
        landCertForEachProp,
        purgeDate,
        returnResourceRef,
        status,
        lMigrated,
        createDate,
        lastUpdateDate,
        declaration
      )
    ).mapTo[ReturnRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(returnId),
        Rep.Some(storn),
        Rep.Some(purchaserCounter),
        Rep.Some(vendorCounter),
        Rep.Some(landCounter),
        version,
        mainPurchaserId,
        mainVendorId,
        mainLandId,
        irmarkGenerated,
        landCertForEachProp,
        purgeDate,
        returnResourceRef,
        Rep.Some(status),
        lMigrated,
        Rep.Some(createDate),
        Rep.Some(lastUpdateDate),
        declaration
      )
    ).shaped.<>(
      { r =>
        import r._;
        _1.map(_ =>
          (ReturnRow.apply _).tupled(
            (
              _1.get,
              _2.get,
              _3.get,
              _4.get,
              _5.get,
              _6,
              _7,
              _8,
              _9,
              _10,
              _11,
              _12,
              _13,
              _14.get,
              _15,
              _16.get,
              _17.get,
              _18
            )
          )
        )
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column RETURN_ID SqlType(NUMBER), PrimaryKey */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID", O.PrimaryKey)

    /** Database column STORN SqlType(VARCHAR2), Length(10,true) */
    val storn: Rep[String] = column[String]("STORN", O.Length(10, varying = true))

    /** Database column PURCHASER_COUNTER SqlType(NUMBER) */
    val purchaserCounter: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("PURCHASER_COUNTER")

    /** Database column VENDOR_COUNTER SqlType(NUMBER) */
    val vendorCounter: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("VENDOR_COUNTER")

    /** Database column LAND_COUNTER SqlType(NUMBER) */
    val landCounter: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("LAND_COUNTER")

    /** Database column VERSION SqlType(NUMBER) */
    val version: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("VERSION")

    /** Database column MAIN_PURCHASER_ID SqlType(NUMBER) */
    val mainPurchaserId: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("MAIN_PURCHASER_ID")

    /** Database column MAIN_VENDOR_ID SqlType(NUMBER) */
    val mainVendorId: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("MAIN_VENDOR_ID")

    /** Database column MAIN_LAND_ID SqlType(NUMBER) */
    val mainLandId: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("MAIN_LAND_ID")

    /** Database column IRMARK_GENERATED SqlType(VARCHAR2), Length(255,true) */
    val irmarkGenerated: Rep[Option[String]] = column[Option[String]]("IRMARK_GENERATED", O.Length(255, varying = true))

    /** Database column LAND_CERT_FOR_EACH_PROP SqlType(VARCHAR2), Length(3,true) */
    val landCertForEachProp: Rep[Option[String]] =
      column[Option[String]]("LAND_CERT_FOR_EACH_PROP", O.Length(3, varying = true))

    /** Database column PURGE_DATE SqlType(DATE) */
    val purgeDate: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("PURGE_DATE")

    /** Database column RETURN_RESOURCE_REF SqlType(NUMBER) */
    val returnResourceRef: Rep[Option[scala.math.BigDecimal]] =
      column[Option[scala.math.BigDecimal]]("RETURN_RESOURCE_REF")

    /** Database column STATUS SqlType(VARCHAR2), Length(20,true) */
    val status: Rep[String] = column[String]("STATUS", O.Length(20, varying = true))

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")

    /** Database column DECLARATION SqlType(VARCHAR2), Length(20,true) */
    val declaration: Rep[Option[String]] = column[Option[String]]("DECLARATION", O.Length(20, varying = true))

    /** Foreign key referencing Land (database name RETURN_MAINLANDID_FCK) */
    lazy val landFk = foreignKey("RETURN_MAINLANDID_FCK", mainLandId, Land)(
      r => Rep.Some(r.landId),
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )

    /** Foreign key referencing Purchaser (database name RETURN_MAINPURCHASERID_FCK) */
    lazy val purchaserFk = foreignKey("RETURN_MAINPURCHASERID_FCK", mainPurchaserId, Purchaser)(
      r => Rep.Some(r.purchaserId),
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )

    /** Foreign key referencing SdltOrganisation (database name RETURN_STORN_FCK) */
    lazy val sdltOrganisationFk = foreignKey("RETURN_STORN_FCK", storn, SdltOrganisation)(
      r => r.storn,
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )

    /** Foreign key referencing Vendor (database name RETURN_MAINVENDORID_FCK) */
    lazy val vendorFk = foreignKey("RETURN_MAINVENDORID_FCK", mainVendorId, Vendor)(
      r => Rep.Some(r.vendorId),
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )

    /** Uniqueness Index over (mainLandId) (database name RETURN_MAINLANDID_IDX) */
    val index1 = index("RETURN_MAINLANDID_IDX", mainLandId, unique = true)

    /** Uniqueness Index over (mainPurchaserId) (database name RETURN_MAINPURCHASERID_IDX) */
    val index2 = index("RETURN_MAINPURCHASERID_IDX", mainPurchaserId, unique = true)

    /** Uniqueness Index over (mainVendorId) (database name RETURN_MAINVENDORID_IDX) */
    val index3 = index("RETURN_MAINVENDORID_IDX", mainVendorId, unique = true)
  }

  /** Collection-like TableQuery object for table Return */
  lazy val Return = new TableQuery(tag => new Return(tag))

  /** Entity class storing rows of table ReturnAgent
    * @param returnAgentId
    *   Database column RETURN_AGENT_ID SqlType(NUMBER), PrimaryKey
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param agentType
    *   Database column AGENT_TYPE SqlType(VARCHAR2), Length(9,true)
    * @param name
    *   Database column NAME SqlType(VARCHAR2), Length(500,true)
    * @param houseNumber
    *   Database column HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param address1
    *   Database column ADDRESS_1 SqlType(VARCHAR2), Length(500,true)
    * @param address2
    *   Database column ADDRESS_2 SqlType(VARCHAR2), Length(500,true)
    * @param address3
    *   Database column ADDRESS_3 SqlType(VARCHAR2), Length(500,true)
    * @param address4
    *   Database column ADDRESS_4 SqlType(VARCHAR2), Length(500,true)
    * @param postcode
    *   Database column POSTCODE SqlType(VARCHAR2), Length(500,true)
    * @param phone
    *   Database column PHONE SqlType(VARCHAR2), Length(500,true)
    * @param email
    *   Database column EMAIL SqlType(VARCHAR2), Length(500,true)
    * @param dxAddress
    *   Database column DX_ADDRESS SqlType(VARCHAR2), Length(500,true)
    * @param reference
    *   Database column REFERENCE SqlType(VARCHAR2), Length(500,true)
    * @param isAuthorised
    *   Database column IS_AUTHORISED SqlType(VARCHAR2), Length(3,true)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    */
  case class ReturnAgentRow(
    returnAgentId: scala.math.BigDecimal,
    returnId: Option[scala.math.BigDecimal],
    agentType: String,
    name: Option[String],
    houseNumber: Option[String],
    address1: Option[String],
    address2: Option[String],
    address3: Option[String],
    address4: Option[String],
    postcode: Option[String],
    phone: Option[String],
    email: Option[String],
    dxAddress: Option[String],
    reference: Option[String],
    isAuthorised: Option[String],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp
  )

  /** GetResult implicit for fetching ReturnAgentRow objects using plain SQL queries */
  implicit def GetResultReturnAgentRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[scala.math.BigDecimal]],
    e2: GR[String],
    e3: GR[Option[String]],
    e4: GR[java.sql.Timestamp]
  ): GR[ReturnAgentRow] = GR { prs =>
    import prs._
    (ReturnAgentRow.apply _).tupled(
      (
        <<[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[scala.math.BigDecimal],
        <<[java.sql.Timestamp],
        <<[java.sql.Timestamp]
      )
    )
  }

  /** Table description of table RETURN_AGENT. Objects of this class serve as prototypes for rows in queries. */
  class ReturnAgent(_tableTag: Tag)
      extends profile.api.Table[ReturnAgentRow](_tableTag, Some("SDLT_FILE_DATA"), "RETURN_AGENT") {
    def * = (
      (
        returnAgentId,
        returnId,
        agentType,
        name,
        houseNumber,
        address1,
        address2,
        address3,
        address4,
        postcode,
        phone,
        email,
        dxAddress,
        reference,
        isAuthorised,
        lMigrated,
        createDate,
        lastUpdateDate
      )
    ).mapTo[ReturnAgentRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(returnAgentId),
        returnId,
        Rep.Some(agentType),
        name,
        houseNumber,
        address1,
        address2,
        address3,
        address4,
        postcode,
        phone,
        email,
        dxAddress,
        reference,
        isAuthorised,
        lMigrated,
        Rep.Some(createDate),
        Rep.Some(lastUpdateDate)
      )
    ).shaped.<>(
      { r =>
        import r._;
        _1.map(_ =>
          (ReturnAgentRow.apply _)
            .tupled((_1.get, _2, _3.get, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17.get, _18.get))
        )
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column RETURN_AGENT_ID SqlType(NUMBER), PrimaryKey */
    val returnAgentId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_AGENT_ID", O.PrimaryKey)

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("RETURN_ID")

    /** Database column AGENT_TYPE SqlType(VARCHAR2), Length(9,true) */
    val agentType: Rep[String] = column[String]("AGENT_TYPE", O.Length(9, varying = true))

    /** Database column NAME SqlType(VARCHAR2), Length(500,true) */
    val name: Rep[Option[String]] = column[Option[String]]("NAME", O.Length(500, varying = true))

    /** Database column HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val houseNumber: Rep[Option[String]] = column[Option[String]]("HOUSE_NUMBER", O.Length(500, varying = true))

    /** Database column ADDRESS_1 SqlType(VARCHAR2), Length(500,true) */
    val address1: Rep[Option[String]] = column[Option[String]]("ADDRESS_1", O.Length(500, varying = true))

    /** Database column ADDRESS_2 SqlType(VARCHAR2), Length(500,true) */
    val address2: Rep[Option[String]] = column[Option[String]]("ADDRESS_2", O.Length(500, varying = true))

    /** Database column ADDRESS_3 SqlType(VARCHAR2), Length(500,true) */
    val address3: Rep[Option[String]] = column[Option[String]]("ADDRESS_3", O.Length(500, varying = true))

    /** Database column ADDRESS_4 SqlType(VARCHAR2), Length(500,true) */
    val address4: Rep[Option[String]] = column[Option[String]]("ADDRESS_4", O.Length(500, varying = true))

    /** Database column POSTCODE SqlType(VARCHAR2), Length(500,true) */
    val postcode: Rep[Option[String]] = column[Option[String]]("POSTCODE", O.Length(500, varying = true))

    /** Database column PHONE SqlType(VARCHAR2), Length(500,true) */
    val phone: Rep[Option[String]] = column[Option[String]]("PHONE", O.Length(500, varying = true))

    /** Database column EMAIL SqlType(VARCHAR2), Length(500,true) */
    val email: Rep[Option[String]] = column[Option[String]]("EMAIL", O.Length(500, varying = true))

    /** Database column DX_ADDRESS SqlType(VARCHAR2), Length(500,true) */
    val dxAddress: Rep[Option[String]] = column[Option[String]]("DX_ADDRESS", O.Length(500, varying = true))

    /** Database column REFERENCE SqlType(VARCHAR2), Length(500,true) */
    val reference: Rep[Option[String]] = column[Option[String]]("REFERENCE", O.Length(500, varying = true))

    /** Database column IS_AUTHORISED SqlType(VARCHAR2), Length(3,true) */
    val isAuthorised: Rep[Option[String]] = column[Option[String]]("IS_AUTHORISED", O.Length(3, varying = true))

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")

    /** Foreign key referencing Return (database name RETURN_AGENT_RETURNID_FCK) */
    lazy val returnFk = foreignKey("RETURN_AGENT_RETURNID_FCK", returnId, Return)(
      r => Rep.Some(r.returnId),
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )

    /** Index over (agentType) (database name RETURN_AGENT_AGENTTYPE_IDX) */
    val index1 = index("RETURN_AGENT_AGENTTYPE_IDX", agentType)

    /** Uniqueness Index over (returnId,agentType) (database name UNIQUE_RETURN_ID_AGENT_TYPE) */
    val index2 = index("UNIQUE_RETURN_ID_AGENT_TYPE", (returnId, agentType), unique = true)
  }

  /** Collection-like TableQuery object for table ReturnAgent */
  lazy val ReturnAgent = new TableQuery(tag => new ReturnAgent(tag))

  /** Entity class storing rows of table ReturnAgentBackup
    * @param returnAgentId
    *   Database column RETURN_AGENT_ID SqlType(NUMBER)
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param agentType
    *   Database column AGENT_TYPE SqlType(VARCHAR2), Length(9,true)
    * @param name
    *   Database column NAME SqlType(VARCHAR2), Length(500,true)
    * @param houseNumber
    *   Database column HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param address1
    *   Database column ADDRESS_1 SqlType(VARCHAR2), Length(500,true)
    * @param address2
    *   Database column ADDRESS_2 SqlType(VARCHAR2), Length(500,true)
    * @param address3
    *   Database column ADDRESS_3 SqlType(VARCHAR2), Length(500,true)
    * @param address4
    *   Database column ADDRESS_4 SqlType(VARCHAR2), Length(500,true)
    * @param postcode
    *   Database column POSTCODE SqlType(VARCHAR2), Length(500,true)
    * @param phone
    *   Database column PHONE SqlType(VARCHAR2), Length(500,true)
    * @param email
    *   Database column EMAIL SqlType(VARCHAR2), Length(500,true)
    * @param dxAddress
    *   Database column DX_ADDRESS SqlType(VARCHAR2), Length(500,true)
    * @param reference
    *   Database column REFERENCE SqlType(VARCHAR2), Length(500,true)
    * @param isAuthorised
    *   Database column IS_AUTHORISED SqlType(VARCHAR2), Length(3,true)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    */
  case class ReturnAgentBackupRow(
    returnAgentId: scala.math.BigDecimal,
    returnId: Option[scala.math.BigDecimal],
    agentType: String,
    name: Option[String],
    houseNumber: Option[String],
    address1: Option[String],
    address2: Option[String],
    address3: Option[String],
    address4: Option[String],
    postcode: Option[String],
    phone: Option[String],
    email: Option[String],
    dxAddress: Option[String],
    reference: Option[String],
    isAuthorised: Option[String],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp
  )

  /** GetResult implicit for fetching ReturnAgentBackupRow objects using plain SQL queries */
  implicit def GetResultReturnAgentBackupRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[scala.math.BigDecimal]],
    e2: GR[String],
    e3: GR[Option[String]],
    e4: GR[java.sql.Timestamp]
  ): GR[ReturnAgentBackupRow] = GR { prs =>
    import prs._
    (ReturnAgentBackupRow.apply _).tupled(
      (
        <<[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[scala.math.BigDecimal],
        <<[java.sql.Timestamp],
        <<[java.sql.Timestamp]
      )
    )
  }

  /** Table description of table RETURN_AGENT_BACKUP. Objects of this class serve as prototypes for rows in queries. */
  class ReturnAgentBackup(_tableTag: Tag)
      extends profile.api.Table[ReturnAgentBackupRow](_tableTag, Some("SDLT_FILE_DATA"), "RETURN_AGENT_BACKUP") {
    def * = (
      (
        returnAgentId,
        returnId,
        agentType,
        name,
        houseNumber,
        address1,
        address2,
        address3,
        address4,
        postcode,
        phone,
        email,
        dxAddress,
        reference,
        isAuthorised,
        lMigrated,
        createDate,
        lastUpdateDate
      )
    ).mapTo[ReturnAgentBackupRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(returnAgentId),
        returnId,
        Rep.Some(agentType),
        name,
        houseNumber,
        address1,
        address2,
        address3,
        address4,
        postcode,
        phone,
        email,
        dxAddress,
        reference,
        isAuthorised,
        lMigrated,
        Rep.Some(createDate),
        Rep.Some(lastUpdateDate)
      )
    ).shaped.<>(
      { r =>
        import r._;
        _1.map(_ =>
          (ReturnAgentBackupRow.apply _)
            .tupled((_1.get, _2, _3.get, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17.get, _18.get))
        )
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column RETURN_AGENT_ID SqlType(NUMBER) */
    val returnAgentId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_AGENT_ID")

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("RETURN_ID")

    /** Database column AGENT_TYPE SqlType(VARCHAR2), Length(9,true) */
    val agentType: Rep[String] = column[String]("AGENT_TYPE", O.Length(9, varying = true))

    /** Database column NAME SqlType(VARCHAR2), Length(500,true) */
    val name: Rep[Option[String]] = column[Option[String]]("NAME", O.Length(500, varying = true))

    /** Database column HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val houseNumber: Rep[Option[String]] = column[Option[String]]("HOUSE_NUMBER", O.Length(500, varying = true))

    /** Database column ADDRESS_1 SqlType(VARCHAR2), Length(500,true) */
    val address1: Rep[Option[String]] = column[Option[String]]("ADDRESS_1", O.Length(500, varying = true))

    /** Database column ADDRESS_2 SqlType(VARCHAR2), Length(500,true) */
    val address2: Rep[Option[String]] = column[Option[String]]("ADDRESS_2", O.Length(500, varying = true))

    /** Database column ADDRESS_3 SqlType(VARCHAR2), Length(500,true) */
    val address3: Rep[Option[String]] = column[Option[String]]("ADDRESS_3", O.Length(500, varying = true))

    /** Database column ADDRESS_4 SqlType(VARCHAR2), Length(500,true) */
    val address4: Rep[Option[String]] = column[Option[String]]("ADDRESS_4", O.Length(500, varying = true))

    /** Database column POSTCODE SqlType(VARCHAR2), Length(500,true) */
    val postcode: Rep[Option[String]] = column[Option[String]]("POSTCODE", O.Length(500, varying = true))

    /** Database column PHONE SqlType(VARCHAR2), Length(500,true) */
    val phone: Rep[Option[String]] = column[Option[String]]("PHONE", O.Length(500, varying = true))

    /** Database column EMAIL SqlType(VARCHAR2), Length(500,true) */
    val email: Rep[Option[String]] = column[Option[String]]("EMAIL", O.Length(500, varying = true))

    /** Database column DX_ADDRESS SqlType(VARCHAR2), Length(500,true) */
    val dxAddress: Rep[Option[String]] = column[Option[String]]("DX_ADDRESS", O.Length(500, varying = true))

    /** Database column REFERENCE SqlType(VARCHAR2), Length(500,true) */
    val reference: Rep[Option[String]] = column[Option[String]]("REFERENCE", O.Length(500, varying = true))

    /** Database column IS_AUTHORISED SqlType(VARCHAR2), Length(3,true) */
    val isAuthorised: Rep[Option[String]] = column[Option[String]]("IS_AUTHORISED", O.Length(3, varying = true))

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")
  }

  /** Collection-like TableQuery object for table ReturnAgentBackup */
  lazy val ReturnAgentBackup = new TableQuery(tag => new ReturnAgentBackup(tag))

  /** Entity class storing rows of table ReturnBackup
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param storn
    *   Database column STORN SqlType(VARCHAR2), Length(10,true)
    * @param purchaserCounter
    *   Database column PURCHASER_COUNTER SqlType(NUMBER)
    * @param vendorCounter
    *   Database column VENDOR_COUNTER SqlType(NUMBER)
    * @param landCounter
    *   Database column LAND_COUNTER SqlType(NUMBER)
    * @param version
    *   Database column VERSION SqlType(NUMBER)
    * @param mainPurchaserId
    *   Database column MAIN_PURCHASER_ID SqlType(NUMBER)
    * @param mainVendorId
    *   Database column MAIN_VENDOR_ID SqlType(NUMBER)
    * @param mainLandId
    *   Database column MAIN_LAND_ID SqlType(NUMBER)
    * @param irmarkGenerated
    *   Database column IRMARK_GENERATED SqlType(VARCHAR2), Length(255,true)
    * @param landCertForEachProp
    *   Database column LAND_CERT_FOR_EACH_PROP SqlType(VARCHAR2), Length(3,true)
    * @param purgeDate
    *   Database column PURGE_DATE SqlType(DATE)
    * @param returnResourceRef
    *   Database column RETURN_RESOURCE_REF SqlType(NUMBER)
    * @param status
    *   Database column STATUS SqlType(VARCHAR2), Length(20,true)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    * @param declaration
    *   Database column DECLARATION SqlType(VARCHAR2), Length(20,true)
    */
  case class ReturnBackupRow(
    returnId: scala.math.BigDecimal,
    storn: String,
    purchaserCounter: scala.math.BigDecimal,
    vendorCounter: scala.math.BigDecimal,
    landCounter: scala.math.BigDecimal,
    version: Option[scala.math.BigDecimal],
    mainPurchaserId: Option[scala.math.BigDecimal],
    mainVendorId: Option[scala.math.BigDecimal],
    mainLandId: Option[scala.math.BigDecimal],
    irmarkGenerated: Option[String],
    landCertForEachProp: Option[String],
    purgeDate: Option[java.sql.Timestamp],
    returnResourceRef: Option[scala.math.BigDecimal],
    status: String,
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp,
    declaration: Option[String]
  )

  /** GetResult implicit for fetching ReturnBackupRow objects using plain SQL queries */
  implicit def GetResultReturnBackupRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[String],
    e2: GR[Option[scala.math.BigDecimal]],
    e3: GR[Option[String]],
    e4: GR[Option[java.sql.Timestamp]],
    e5: GR[java.sql.Timestamp]
  ): GR[ReturnBackupRow] = GR { prs =>
    import prs._
    (ReturnBackupRow.apply _).tupled(
      (
        <<[scala.math.BigDecimal],
        <<[String],
        <<[scala.math.BigDecimal],
        <<[scala.math.BigDecimal],
        <<[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[String],
        <<?[String],
        <<?[java.sql.Timestamp],
        <<?[scala.math.BigDecimal],
        <<[String],
        <<?[scala.math.BigDecimal],
        <<[java.sql.Timestamp],
        <<[java.sql.Timestamp],
        <<?[String]
      )
    )
  }

  /** Table description of table RETURN_BACKUP. Objects of this class serve as prototypes for rows in queries. */
  class ReturnBackup(_tableTag: Tag)
      extends profile.api.Table[ReturnBackupRow](_tableTag, Some("SDLT_FILE_DATA"), "RETURN_BACKUP") {
    def * = (
      (
        returnId,
        storn,
        purchaserCounter,
        vendorCounter,
        landCounter,
        version,
        mainPurchaserId,
        mainVendorId,
        mainLandId,
        irmarkGenerated,
        landCertForEachProp,
        purgeDate,
        returnResourceRef,
        status,
        lMigrated,
        createDate,
        lastUpdateDate,
        declaration
      )
    ).mapTo[ReturnBackupRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(returnId),
        Rep.Some(storn),
        Rep.Some(purchaserCounter),
        Rep.Some(vendorCounter),
        Rep.Some(landCounter),
        version,
        mainPurchaserId,
        mainVendorId,
        mainLandId,
        irmarkGenerated,
        landCertForEachProp,
        purgeDate,
        returnResourceRef,
        Rep.Some(status),
        lMigrated,
        Rep.Some(createDate),
        Rep.Some(lastUpdateDate),
        declaration
      )
    ).shaped.<>(
      { r =>
        import r._;
        _1.map(_ =>
          (ReturnBackupRow.apply _).tupled(
            (
              _1.get,
              _2.get,
              _3.get,
              _4.get,
              _5.get,
              _6,
              _7,
              _8,
              _9,
              _10,
              _11,
              _12,
              _13,
              _14.get,
              _15,
              _16.get,
              _17.get,
              _18
            )
          )
        )
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column STORN SqlType(VARCHAR2), Length(10,true) */
    val storn: Rep[String] = column[String]("STORN", O.Length(10, varying = true))

    /** Database column PURCHASER_COUNTER SqlType(NUMBER) */
    val purchaserCounter: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("PURCHASER_COUNTER")

    /** Database column VENDOR_COUNTER SqlType(NUMBER) */
    val vendorCounter: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("VENDOR_COUNTER")

    /** Database column LAND_COUNTER SqlType(NUMBER) */
    val landCounter: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("LAND_COUNTER")

    /** Database column VERSION SqlType(NUMBER) */
    val version: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("VERSION")

    /** Database column MAIN_PURCHASER_ID SqlType(NUMBER) */
    val mainPurchaserId: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("MAIN_PURCHASER_ID")

    /** Database column MAIN_VENDOR_ID SqlType(NUMBER) */
    val mainVendorId: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("MAIN_VENDOR_ID")

    /** Database column MAIN_LAND_ID SqlType(NUMBER) */
    val mainLandId: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("MAIN_LAND_ID")

    /** Database column IRMARK_GENERATED SqlType(VARCHAR2), Length(255,true) */
    val irmarkGenerated: Rep[Option[String]] = column[Option[String]]("IRMARK_GENERATED", O.Length(255, varying = true))

    /** Database column LAND_CERT_FOR_EACH_PROP SqlType(VARCHAR2), Length(3,true) */
    val landCertForEachProp: Rep[Option[String]] =
      column[Option[String]]("LAND_CERT_FOR_EACH_PROP", O.Length(3, varying = true))

    /** Database column PURGE_DATE SqlType(DATE) */
    val purgeDate: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("PURGE_DATE")

    /** Database column RETURN_RESOURCE_REF SqlType(NUMBER) */
    val returnResourceRef: Rep[Option[scala.math.BigDecimal]] =
      column[Option[scala.math.BigDecimal]]("RETURN_RESOURCE_REF")

    /** Database column STATUS SqlType(VARCHAR2), Length(20,true) */
    val status: Rep[String] = column[String]("STATUS", O.Length(20, varying = true))

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")

    /** Database column DECLARATION SqlType(VARCHAR2), Length(20,true) */
    val declaration: Rep[Option[String]] = column[Option[String]]("DECLARATION", O.Length(20, varying = true))
  }

  /** Collection-like TableQuery object for table ReturnBackup */
  lazy val ReturnBackup = new TableQuery(tag => new ReturnBackup(tag))

  /** Entity class storing rows of table SdltOrganisation
    * @param storn
    *   Database column STORN SqlType(VARCHAR2), PrimaryKey, Length(10,true)
    * @param doNotDisplayWelcomePage
    *   Database column DO_NOT_DISPLAY_WELCOME_PAGE SqlType(VARCHAR2), Length(3,true)
    * @param isReturnUser
    *   Database column IS_RETURN_USER SqlType(VARCHAR2), Length(4,true)
    * @param agentCounter
    *   Database column AGENT_COUNTER SqlType(NUMBER)
    * @param returnCounter
    *   Database column RETURN_COUNTER SqlType(NUMBER)
    * @param version
    *   Database column VERSION SqlType(NUMBER)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    */
  case class SdltOrganisationRow(
    storn: String,
    doNotDisplayWelcomePage: Option[String],
    isReturnUser: Option[String],
    agentCounter: Option[scala.math.BigDecimal],
    returnCounter: Option[scala.math.BigDecimal],
    version: Option[scala.math.BigDecimal],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp
  )

  /** GetResult implicit for fetching SdltOrganisationRow objects using plain SQL queries */
  implicit def GetResultSdltOrganisationRow(implicit
    e0: GR[String],
    e1: GR[Option[String]],
    e2: GR[Option[scala.math.BigDecimal]],
    e3: GR[java.sql.Timestamp]
  ): GR[SdltOrganisationRow] = GR { prs =>
    import prs._
    (SdltOrganisationRow.apply _).tupled(
      (
        <<[String],
        <<?[String],
        <<?[String],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<[java.sql.Timestamp],
        <<[java.sql.Timestamp]
      )
    )
  }

  /** Table description of table SDLT_ORGANISATION. Objects of this class serve as prototypes for rows in queries. */
  class SdltOrganisation(_tableTag: Tag)
      extends profile.api.Table[SdltOrganisationRow](_tableTag, Some("SDLT_FILE_DATA"), "SDLT_ORGANISATION") {
    def * = (
      (
        storn,
        doNotDisplayWelcomePage,
        isReturnUser,
        agentCounter,
        returnCounter,
        version,
        lMigrated,
        createDate,
        lastUpdateDate
      )
    ).mapTo[SdltOrganisationRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(storn),
        doNotDisplayWelcomePage,
        isReturnUser,
        agentCounter,
        returnCounter,
        version,
        lMigrated,
        Rep.Some(createDate),
        Rep.Some(lastUpdateDate)
      )
    ).shaped.<>(
      { r =>
        import r._; _1.map(_ => (SdltOrganisationRow.apply _).tupled((_1.get, _2, _3, _4, _5, _6, _7, _8.get, _9.get)))
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column STORN SqlType(VARCHAR2), PrimaryKey, Length(10,true) */
    val storn: Rep[String] = column[String]("STORN", O.PrimaryKey, O.Length(10, varying = true))

    /** Database column DO_NOT_DISPLAY_WELCOME_PAGE SqlType(VARCHAR2), Length(3,true) */
    val doNotDisplayWelcomePage: Rep[Option[String]] =
      column[Option[String]]("DO_NOT_DISPLAY_WELCOME_PAGE", O.Length(3, varying = true))

    /** Database column IS_RETURN_USER SqlType(VARCHAR2), Length(4,true) */
    val isReturnUser: Rep[Option[String]] = column[Option[String]]("IS_RETURN_USER", O.Length(4, varying = true))

    /** Database column AGENT_COUNTER SqlType(NUMBER) */
    val agentCounter: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("AGENT_COUNTER")

    /** Database column RETURN_COUNTER SqlType(NUMBER) */
    val returnCounter: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("RETURN_COUNTER")

    /** Database column VERSION SqlType(NUMBER) */
    val version: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("VERSION")

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")
  }

  /** Collection-like TableQuery object for table SdltOrganisation */
  lazy val SdltOrganisation = new TableQuery(tag => new SdltOrganisation(tag))

  /** Entity class storing rows of table Submission
    * @param submissionId
    *   Database column SUBMISSION_ID SqlType(NUMBER), PrimaryKey
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param storn
    *   Database column STORN SqlType(VARCHAR2), Length(10,true)
    * @param submissionStatus
    *   Database column SUBMISSION_STATUS SqlType(VARCHAR2), Length(255,true)
    * @param govtalkMessageClass
    *   Database column GOVTALK_MESSAGE_CLASS SqlType(VARCHAR2), Length(255,true)
    * @param utrn
    *   Database column UTRN SqlType(VARCHAR2), Length(500,true)
    * @param irmarkReceived
    *   Database column IRMARK_RECEIVED SqlType(VARCHAR2), Length(255,true)
    * @param submissionReceipt
    *   Database column SUBMISSION_RECEIPT SqlType(VARCHAR2), Length(4000,true)
    * @param govtalkErrorCode
    *   Database column GOVTALK_ERROR_CODE SqlType(VARCHAR2), Length(255,true)
    * @param govtalkErrorType
    *   Database column GOVTALK_ERROR_TYPE SqlType(VARCHAR2), Length(255,true)
    * @param govtalkErrorMessage
    *   Database column GOVTALK_ERROR_MESSAGE SqlType(VARCHAR2), Length(255,true)
    * @param numPolls
    *   Database column NUM_POLLS SqlType(NUMBER)
    * @param acceptedDate
    *   Database column ACCEPTED_DATE SqlType(DATE)
    * @param submittedDate
    *   Database column SUBMITTED_DATE SqlType(DATE)
    * @param email
    *   Database column EMAIL SqlType(VARCHAR2), Length(500,true)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param submissionRequestDate
    *   Database column SUBMISSION_REQUEST_DATE SqlType(DATE)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    * @param irMarkSent
    *   Database column IR_MARK_SENT SqlType(VARCHAR2), Length(255,true)
    */
  case class SubmissionRow(
    submissionId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    storn: String,
    submissionStatus: Option[String],
    govtalkMessageClass: Option[String],
    utrn: Option[String],
    irmarkReceived: Option[String],
    submissionReceipt: Option[String],
    govtalkErrorCode: Option[String],
    govtalkErrorType: Option[String],
    govtalkErrorMessage: Option[String],
    numPolls: Option[scala.math.BigDecimal],
    acceptedDate: Option[java.sql.Timestamp],
    submittedDate: Option[java.sql.Timestamp],
    email: Option[String],
    lMigrated: Option[scala.math.BigDecimal],
    submissionRequestDate: Option[java.sql.Timestamp],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp,
    irMarkSent: Option[String]
  )

  /** GetResult implicit for fetching SubmissionRow objects using plain SQL queries */
  implicit def GetResultSubmissionRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[String],
    e2: GR[Option[String]],
    e3: GR[Option[scala.math.BigDecimal]],
    e4: GR[Option[java.sql.Timestamp]],
    e5: GR[java.sql.Timestamp]
  ): GR[SubmissionRow] = GR { prs =>
    import prs._
    (SubmissionRow.apply _).tupled(
      (
        <<[scala.math.BigDecimal],
        <<[scala.math.BigDecimal],
        <<[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[scala.math.BigDecimal],
        <<?[java.sql.Timestamp],
        <<?[java.sql.Timestamp],
        <<?[String],
        <<?[scala.math.BigDecimal],
        <<?[java.sql.Timestamp],
        <<[java.sql.Timestamp],
        <<[java.sql.Timestamp],
        <<?[String]
      )
    )
  }

  /** Table description of table SUBMISSION. Objects of this class serve as prototypes for rows in queries. */
  class Submission(_tableTag: Tag)
      extends profile.api.Table[SubmissionRow](_tableTag, Some("SDLT_FILE_DATA"), "SUBMISSION") {
    def * = (
      (
        submissionId,
        returnId,
        storn,
        submissionStatus,
        govtalkMessageClass,
        utrn,
        irmarkReceived,
        submissionReceipt,
        govtalkErrorCode,
        govtalkErrorType,
        govtalkErrorMessage,
        numPolls,
        acceptedDate,
        submittedDate,
        email,
        lMigrated,
        submissionRequestDate,
        createDate,
        lastUpdateDate,
        irMarkSent
      )
    ).mapTo[SubmissionRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(submissionId),
        Rep.Some(returnId),
        Rep.Some(storn),
        submissionStatus,
        govtalkMessageClass,
        utrn,
        irmarkReceived,
        submissionReceipt,
        govtalkErrorCode,
        govtalkErrorType,
        govtalkErrorMessage,
        numPolls,
        acceptedDate,
        submittedDate,
        email,
        lMigrated,
        submissionRequestDate,
        Rep.Some(createDate),
        Rep.Some(lastUpdateDate),
        irMarkSent
      )
    ).shaped.<>(
      { r =>
        import r._;
        _1.map(_ =>
          (SubmissionRow.apply _).tupled(
            (
              _1.get,
              _2.get,
              _3.get,
              _4,
              _5,
              _6,
              _7,
              _8,
              _9,
              _10,
              _11,
              _12,
              _13,
              _14,
              _15,
              _16,
              _17,
              _18.get,
              _19.get,
              _20
            )
          )
        )
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column SUBMISSION_ID SqlType(NUMBER), PrimaryKey */
    val submissionId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("SUBMISSION_ID", O.PrimaryKey)

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column STORN SqlType(VARCHAR2), Length(10,true) */
    val storn: Rep[String] = column[String]("STORN", O.Length(10, varying = true))

    /** Database column SUBMISSION_STATUS SqlType(VARCHAR2), Length(255,true) */
    val submissionStatus: Rep[Option[String]] =
      column[Option[String]]("SUBMISSION_STATUS", O.Length(255, varying = true))

    /** Database column GOVTALK_MESSAGE_CLASS SqlType(VARCHAR2), Length(255,true) */
    val govtalkMessageClass: Rep[Option[String]] =
      column[Option[String]]("GOVTALK_MESSAGE_CLASS", O.Length(255, varying = true))

    /** Database column UTRN SqlType(VARCHAR2), Length(500,true) */
    val utrn: Rep[Option[String]] = column[Option[String]]("UTRN", O.Length(500, varying = true))

    /** Database column IRMARK_RECEIVED SqlType(VARCHAR2), Length(255,true) */
    val irmarkReceived: Rep[Option[String]] = column[Option[String]]("IRMARK_RECEIVED", O.Length(255, varying = true))

    /** Database column SUBMISSION_RECEIPT SqlType(VARCHAR2), Length(4000,true) */
    val submissionReceipt: Rep[Option[String]] =
      column[Option[String]]("SUBMISSION_RECEIPT", O.Length(4000, varying = true))

    /** Database column GOVTALK_ERROR_CODE SqlType(VARCHAR2), Length(255,true) */
    val govtalkErrorCode: Rep[Option[String]] =
      column[Option[String]]("GOVTALK_ERROR_CODE", O.Length(255, varying = true))

    /** Database column GOVTALK_ERROR_TYPE SqlType(VARCHAR2), Length(255,true) */
    val govtalkErrorType: Rep[Option[String]] =
      column[Option[String]]("GOVTALK_ERROR_TYPE", O.Length(255, varying = true))

    /** Database column GOVTALK_ERROR_MESSAGE SqlType(VARCHAR2), Length(255,true) */
    val govtalkErrorMessage: Rep[Option[String]] =
      column[Option[String]]("GOVTALK_ERROR_MESSAGE", O.Length(255, varying = true))

    /** Database column NUM_POLLS SqlType(NUMBER) */
    val numPolls: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("NUM_POLLS")

    /** Database column ACCEPTED_DATE SqlType(DATE) */
    val acceptedDate: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("ACCEPTED_DATE")

    /** Database column SUBMITTED_DATE SqlType(DATE) */
    val submittedDate: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("SUBMITTED_DATE")

    /** Database column EMAIL SqlType(VARCHAR2), Length(500,true) */
    val email: Rep[Option[String]] = column[Option[String]]("EMAIL", O.Length(500, varying = true))

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column SUBMISSION_REQUEST_DATE SqlType(DATE) */
    val submissionRequestDate: Rep[Option[java.sql.Timestamp]] =
      column[Option[java.sql.Timestamp]]("SUBMISSION_REQUEST_DATE")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")

    /** Database column IR_MARK_SENT SqlType(VARCHAR2), Length(255,true) */
    val irMarkSent: Rep[Option[String]] = column[Option[String]]("IR_MARK_SENT", O.Length(255, varying = true))

    /** Foreign key referencing Return (database name SUBMISSION_RETURN_FK) */
    lazy val returnFk = foreignKey("SUBMISSION_RETURN_FK", returnId, Return)(
      r => r.returnId,
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )

    /** Foreign key referencing SdltOrganisation (database name SUBMISSION_SDLT_USER_FK) */
    lazy val sdltOrganisationFk = foreignKey("SUBMISSION_SDLT_USER_FK", storn, SdltOrganisation)(
      r => r.storn,
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )

    /** Uniqueness Index over (returnId) (database name SUBMISSION_RETURNID_IDX) */
    val index1 = index("SUBMISSION_RETURNID_IDX", returnId, unique = true)
  }

  /** Collection-like TableQuery object for table Submission */
  lazy val Submission = new TableQuery(tag => new Submission(tag))

  /** Entity class storing rows of table SubmissionBackup
    * @param submissionId
    *   Database column SUBMISSION_ID SqlType(NUMBER)
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param storn
    *   Database column STORN SqlType(VARCHAR2), Length(10,true)
    * @param submissionStatus
    *   Database column SUBMISSION_STATUS SqlType(VARCHAR2), Length(255,true)
    * @param govtalkMessageClass
    *   Database column GOVTALK_MESSAGE_CLASS SqlType(VARCHAR2), Length(255,true)
    * @param utrn
    *   Database column UTRN SqlType(VARCHAR2), Length(500,true)
    * @param irmarkReceived
    *   Database column IRMARK_RECEIVED SqlType(VARCHAR2), Length(255,true)
    * @param submissionReceipt
    *   Database column SUBMISSION_RECEIPT SqlType(VARCHAR2), Length(4000,true)
    * @param govtalkErrorCode
    *   Database column GOVTALK_ERROR_CODE SqlType(VARCHAR2), Length(255,true)
    * @param govtalkErrorType
    *   Database column GOVTALK_ERROR_TYPE SqlType(VARCHAR2), Length(255,true)
    * @param govtalkErrorMessage
    *   Database column GOVTALK_ERROR_MESSAGE SqlType(VARCHAR2), Length(255,true)
    * @param numPolls
    *   Database column NUM_POLLS SqlType(NUMBER)
    * @param acceptedDate
    *   Database column ACCEPTED_DATE SqlType(DATE)
    * @param submittedDate
    *   Database column SUBMITTED_DATE SqlType(DATE)
    * @param email
    *   Database column EMAIL SqlType(VARCHAR2), Length(500,true)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param submissionRequestDate
    *   Database column SUBMISSION_REQUEST_DATE SqlType(DATE)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    * @param irMarkSent
    *   Database column IR_MARK_SENT SqlType(VARCHAR2), Length(255,true)
    */
  case class SubmissionBackupRow(
    submissionId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    storn: String,
    submissionStatus: Option[String],
    govtalkMessageClass: Option[String],
    utrn: Option[String],
    irmarkReceived: Option[String],
    submissionReceipt: Option[String],
    govtalkErrorCode: Option[String],
    govtalkErrorType: Option[String],
    govtalkErrorMessage: Option[String],
    numPolls: Option[scala.math.BigDecimal],
    acceptedDate: Option[java.sql.Timestamp],
    submittedDate: Option[java.sql.Timestamp],
    email: Option[String],
    lMigrated: Option[scala.math.BigDecimal],
    submissionRequestDate: Option[java.sql.Timestamp],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp,
    irMarkSent: Option[String]
  )

  /** GetResult implicit for fetching SubmissionBackupRow objects using plain SQL queries */
  implicit def GetResultSubmissionBackupRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[String],
    e2: GR[Option[String]],
    e3: GR[Option[scala.math.BigDecimal]],
    e4: GR[Option[java.sql.Timestamp]],
    e5: GR[java.sql.Timestamp]
  ): GR[SubmissionBackupRow] = GR { prs =>
    import prs._
    (SubmissionBackupRow.apply _).tupled(
      (
        <<[scala.math.BigDecimal],
        <<[scala.math.BigDecimal],
        <<[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[scala.math.BigDecimal],
        <<?[java.sql.Timestamp],
        <<?[java.sql.Timestamp],
        <<?[String],
        <<?[scala.math.BigDecimal],
        <<?[java.sql.Timestamp],
        <<[java.sql.Timestamp],
        <<[java.sql.Timestamp],
        <<?[String]
      )
    )
  }

  /** Table description of table SUBMISSION_BACKUP. Objects of this class serve as prototypes for rows in queries. */
  class SubmissionBackup(_tableTag: Tag)
      extends profile.api.Table[SubmissionBackupRow](_tableTag, Some("SDLT_FILE_DATA"), "SUBMISSION_BACKUP") {
    def * = (
      (
        submissionId,
        returnId,
        storn,
        submissionStatus,
        govtalkMessageClass,
        utrn,
        irmarkReceived,
        submissionReceipt,
        govtalkErrorCode,
        govtalkErrorType,
        govtalkErrorMessage,
        numPolls,
        acceptedDate,
        submittedDate,
        email,
        lMigrated,
        submissionRequestDate,
        createDate,
        lastUpdateDate,
        irMarkSent
      )
    ).mapTo[SubmissionBackupRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(submissionId),
        Rep.Some(returnId),
        Rep.Some(storn),
        submissionStatus,
        govtalkMessageClass,
        utrn,
        irmarkReceived,
        submissionReceipt,
        govtalkErrorCode,
        govtalkErrorType,
        govtalkErrorMessage,
        numPolls,
        acceptedDate,
        submittedDate,
        email,
        lMigrated,
        submissionRequestDate,
        Rep.Some(createDate),
        Rep.Some(lastUpdateDate),
        irMarkSent
      )
    ).shaped.<>(
      { r =>
        import r._;
        _1.map(_ =>
          (SubmissionBackupRow.apply _).tupled(
            (
              _1.get,
              _2.get,
              _3.get,
              _4,
              _5,
              _6,
              _7,
              _8,
              _9,
              _10,
              _11,
              _12,
              _13,
              _14,
              _15,
              _16,
              _17,
              _18.get,
              _19.get,
              _20
            )
          )
        )
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column SUBMISSION_ID SqlType(NUMBER) */
    val submissionId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("SUBMISSION_ID")

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column STORN SqlType(VARCHAR2), Length(10,true) */
    val storn: Rep[String] = column[String]("STORN", O.Length(10, varying = true))

    /** Database column SUBMISSION_STATUS SqlType(VARCHAR2), Length(255,true) */
    val submissionStatus: Rep[Option[String]] =
      column[Option[String]]("SUBMISSION_STATUS", O.Length(255, varying = true))

    /** Database column GOVTALK_MESSAGE_CLASS SqlType(VARCHAR2), Length(255,true) */
    val govtalkMessageClass: Rep[Option[String]] =
      column[Option[String]]("GOVTALK_MESSAGE_CLASS", O.Length(255, varying = true))

    /** Database column UTRN SqlType(VARCHAR2), Length(500,true) */
    val utrn: Rep[Option[String]] = column[Option[String]]("UTRN", O.Length(500, varying = true))

    /** Database column IRMARK_RECEIVED SqlType(VARCHAR2), Length(255,true) */
    val irmarkReceived: Rep[Option[String]] = column[Option[String]]("IRMARK_RECEIVED", O.Length(255, varying = true))

    /** Database column SUBMISSION_RECEIPT SqlType(VARCHAR2), Length(4000,true) */
    val submissionReceipt: Rep[Option[String]] =
      column[Option[String]]("SUBMISSION_RECEIPT", O.Length(4000, varying = true))

    /** Database column GOVTALK_ERROR_CODE SqlType(VARCHAR2), Length(255,true) */
    val govtalkErrorCode: Rep[Option[String]] =
      column[Option[String]]("GOVTALK_ERROR_CODE", O.Length(255, varying = true))

    /** Database column GOVTALK_ERROR_TYPE SqlType(VARCHAR2), Length(255,true) */
    val govtalkErrorType: Rep[Option[String]] =
      column[Option[String]]("GOVTALK_ERROR_TYPE", O.Length(255, varying = true))

    /** Database column GOVTALK_ERROR_MESSAGE SqlType(VARCHAR2), Length(255,true) */
    val govtalkErrorMessage: Rep[Option[String]] =
      column[Option[String]]("GOVTALK_ERROR_MESSAGE", O.Length(255, varying = true))

    /** Database column NUM_POLLS SqlType(NUMBER) */
    val numPolls: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("NUM_POLLS")

    /** Database column ACCEPTED_DATE SqlType(DATE) */
    val acceptedDate: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("ACCEPTED_DATE")

    /** Database column SUBMITTED_DATE SqlType(DATE) */
    val submittedDate: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("SUBMITTED_DATE")

    /** Database column EMAIL SqlType(VARCHAR2), Length(500,true) */
    val email: Rep[Option[String]] = column[Option[String]]("EMAIL", O.Length(500, varying = true))

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column SUBMISSION_REQUEST_DATE SqlType(DATE) */
    val submissionRequestDate: Rep[Option[java.sql.Timestamp]] =
      column[Option[java.sql.Timestamp]]("SUBMISSION_REQUEST_DATE")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")

    /** Database column IR_MARK_SENT SqlType(VARCHAR2), Length(255,true) */
    val irMarkSent: Rep[Option[String]] = column[Option[String]]("IR_MARK_SENT", O.Length(255, varying = true))
  }

  /** Collection-like TableQuery object for table SubmissionBackup */
  lazy val SubmissionBackup = new TableQuery(tag => new SubmissionBackup(tag))

  /** Entity class storing rows of table SubmissionErrorDetail
    * @param errorDetailId
    *   Database column ERROR_DETAIL_ID SqlType(NUMBER), PrimaryKey
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param position
    *   Database column POSITION SqlType(NUMBER)
    * @param errorMessage
    *   Database column ERROR_MESSAGE SqlType(VARCHAR2), Length(1000,true)
    * @param storn
    *   Database column STORN SqlType(VARCHAR2), Length(10,true)
    * @param submissionId
    *   Database column SUBMISSION_ID SqlType(NUMBER)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    */
  case class SubmissionErrorDetailRow(
    errorDetailId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    position: Option[scala.math.BigDecimal],
    errorMessage: Option[String],
    storn: String,
    submissionId: scala.math.BigDecimal,
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp
  )

  /** GetResult implicit for fetching SubmissionErrorDetailRow objects using plain SQL queries */
  implicit def GetResultSubmissionErrorDetailRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[scala.math.BigDecimal]],
    e2: GR[Option[String]],
    e3: GR[String],
    e4: GR[java.sql.Timestamp]
  ): GR[SubmissionErrorDetailRow] = GR { prs =>
    import prs._
    (SubmissionErrorDetailRow.apply _).tupled(
      (
        <<[scala.math.BigDecimal],
        <<[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[String],
        <<[String],
        <<[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<[java.sql.Timestamp],
        <<[java.sql.Timestamp]
      )
    )
  }

  /** Table description of table SUBMISSION_ERROR_DETAIL. Objects of this class serve as prototypes for rows in queries.
    */
  class SubmissionErrorDetail(_tableTag: Tag)
      extends profile.api.Table[SubmissionErrorDetailRow](
        _tableTag,
        Some("SDLT_FILE_DATA"),
        "SUBMISSION_ERROR_DETAIL"
      ) {
    def * =
      ((errorDetailId, returnId, position, errorMessage, storn, submissionId, lMigrated, createDate, lastUpdateDate))
        .mapTo[SubmissionErrorDetailRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(errorDetailId),
        Rep.Some(returnId),
        position,
        errorMessage,
        Rep.Some(storn),
        Rep.Some(submissionId),
        lMigrated,
        Rep.Some(createDate),
        Rep.Some(lastUpdateDate)
      )
    ).shaped.<>(
      { r =>
        import r._;
        _1.map(_ =>
          (SubmissionErrorDetailRow.apply _).tupled((_1.get, _2.get, _3, _4, _5.get, _6.get, _7, _8.get, _9.get))
        )
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column ERROR_DETAIL_ID SqlType(NUMBER), PrimaryKey */
    val errorDetailId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("ERROR_DETAIL_ID", O.PrimaryKey)

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column POSITION SqlType(NUMBER) */
    val position: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("POSITION")

    /** Database column ERROR_MESSAGE SqlType(VARCHAR2), Length(1000,true) */
    val errorMessage: Rep[Option[String]] = column[Option[String]]("ERROR_MESSAGE", O.Length(1000, varying = true))

    /** Database column STORN SqlType(VARCHAR2), Length(10,true) */
    val storn: Rep[String] = column[String]("STORN", O.Length(10, varying = true))

    /** Database column SUBMISSION_ID SqlType(NUMBER) */
    val submissionId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("SUBMISSION_ID")

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")

    /** Foreign key referencing Return (database name SUBERRORDETAIL_RETURN_FCK) */
    lazy val returnFk = foreignKey("SUBERRORDETAIL_RETURN_FCK", returnId, Return)(
      r => r.returnId,
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )

    /** Foreign key referencing SdltOrganisation (database name SUBERRORDETAIL_SDLT_ORG_FCK) */
    lazy val sdltOrganisationFk = foreignKey("SUBERRORDETAIL_SDLT_ORG_FCK", storn, SdltOrganisation)(
      r => r.storn,
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )

    /** Foreign key referencing Submission (database name SUBERRORDETAIL_SUBMISSION_FCK) */
    lazy val submissionFk = foreignKey("SUBERRORDETAIL_SUBMISSION_FCK", submissionId, Submission)(
      r => r.submissionId,
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )
  }

  /** Collection-like TableQuery object for table SubmissionErrorDetail */
  lazy val SubmissionErrorDetail = new TableQuery(tag => new SubmissionErrorDetail(tag))

  /** Entity class storing rows of table SubmissionErrorDetailBackup
    * @param errorDetailId
    *   Database column ERROR_DETAIL_ID SqlType(NUMBER)
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param position
    *   Database column POSITION SqlType(NUMBER)
    * @param errorMessage
    *   Database column ERROR_MESSAGE SqlType(VARCHAR2), Length(1000,true)
    * @param storn
    *   Database column STORN SqlType(VARCHAR2), Length(10,true)
    * @param submissionId
    *   Database column SUBMISSION_ID SqlType(NUMBER)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    */
  case class SubmissionErrorDetailBackupRow(
    errorDetailId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    position: Option[scala.math.BigDecimal],
    errorMessage: Option[String],
    storn: String,
    submissionId: scala.math.BigDecimal,
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp
  )

  /** GetResult implicit for fetching SubmissionErrorDetailBackupRow objects using plain SQL queries */
  implicit def GetResultSubmissionErrorDetailBackupRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[scala.math.BigDecimal]],
    e2: GR[Option[String]],
    e3: GR[String],
    e4: GR[java.sql.Timestamp]
  ): GR[SubmissionErrorDetailBackupRow] = GR { prs =>
    import prs._
    (SubmissionErrorDetailBackupRow.apply _).tupled(
      (
        <<[scala.math.BigDecimal],
        <<[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[String],
        <<[String],
        <<[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<[java.sql.Timestamp],
        <<[java.sql.Timestamp]
      )
    )
  }

  /** Table description of table SUBMISSION_ERROR_DETAIL_BACKUP. Objects of this class serve as prototypes for rows in
    * queries.
    */
  class SubmissionErrorDetailBackup(_tableTag: Tag)
      extends profile.api.Table[SubmissionErrorDetailBackupRow](
        _tableTag,
        Some("SDLT_FILE_DATA"),
        "SUBMISSION_ERROR_DETAIL_BACKUP"
      ) {
    def * =
      ((errorDetailId, returnId, position, errorMessage, storn, submissionId, lMigrated, createDate, lastUpdateDate))
        .mapTo[SubmissionErrorDetailBackupRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(errorDetailId),
        Rep.Some(returnId),
        position,
        errorMessage,
        Rep.Some(storn),
        Rep.Some(submissionId),
        lMigrated,
        Rep.Some(createDate),
        Rep.Some(lastUpdateDate)
      )
    ).shaped.<>(
      { r =>
        import r._;
        _1.map(_ =>
          (SubmissionErrorDetailBackupRow.apply _).tupled((_1.get, _2.get, _3, _4, _5.get, _6.get, _7, _8.get, _9.get))
        )
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column ERROR_DETAIL_ID SqlType(NUMBER) */
    val errorDetailId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("ERROR_DETAIL_ID")

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column POSITION SqlType(NUMBER) */
    val position: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("POSITION")

    /** Database column ERROR_MESSAGE SqlType(VARCHAR2), Length(1000,true) */
    val errorMessage: Rep[Option[String]] = column[Option[String]]("ERROR_MESSAGE", O.Length(1000, varying = true))

    /** Database column STORN SqlType(VARCHAR2), Length(10,true) */
    val storn: Rep[String] = column[String]("STORN", O.Length(10, varying = true))

    /** Database column SUBMISSION_ID SqlType(NUMBER) */
    val submissionId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("SUBMISSION_ID")

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")
  }

  /** Collection-like TableQuery object for table SubmissionErrorDetailBackup */
  lazy val SubmissionErrorDetailBackup = new TableQuery(tag => new SubmissionErrorDetailBackup(tag))

  /** Entity class storing rows of table TaxCalculation
    * @param taxCalculationId
    *   Database column TAX_CALCULATION_ID SqlType(NUMBER), PrimaryKey
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param amountPaid
    *   Database column AMOUNT_PAID SqlType(VARCHAR2), Length(500,true)
    * @param includesPenalty
    *   Database column INCLUDES_PENALTY SqlType(VARCHAR2), Length(3,true)
    * @param taxDue
    *   Database column TAX_DUE SqlType(VARCHAR2), Length(500,true)
    * @param calcPenaltyDue
    *   Database column CALC_PENALTY_DUE SqlType(NUMBER)
    * @param calcTaxDue
    *   Database column CALC_TAX_DUE SqlType(NUMBER)
    * @param calcTaxRate1
    *   Database column CALC_TAX_RATE1 SqlType(VARCHAR2), Length(500,true)
    * @param calcTaxRate2
    *   Database column CALC_TAX_RATE2 SqlType(VARCHAR2), Length(500,true)
    * @param calcTotalTaxPenaltyDue
    *   Database column CALC_TOTAL_TAX_PENALTY_DUE SqlType(NUMBER)
    * @param calcTotalNpvTax
    *   Database column CALC_TOTAL_NPV_TAX SqlType(NUMBER)
    * @param calcTotalPremiumTax
    *   Database column CALC_TOTAL_PREMIUM_TAX SqlType(NUMBER)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    * @param taxDuePremium
    *   Database column TAX_DUE_PREMIUM SqlType(VARCHAR2), Length(500,true)
    * @param taxDueNpv
    *   Database column TAX_DUE_NPV SqlType(VARCHAR2), Length(500,true)
    * @param honestyDeclaration
    *   Database column HONESTY_DECLARATION SqlType(VARCHAR2), Length(3,true)
    */
  case class TaxCalculationRow(
    taxCalculationId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    amountPaid: Option[String],
    includesPenalty: Option[String],
    taxDue: Option[String],
    calcPenaltyDue: Option[scala.math.BigDecimal],
    calcTaxDue: Option[scala.math.BigDecimal],
    calcTaxRate1: Option[String],
    calcTaxRate2: Option[String],
    calcTotalTaxPenaltyDue: Option[scala.math.BigDecimal],
    calcTotalNpvTax: Option[scala.math.BigDecimal],
    calcTotalPremiumTax: Option[scala.math.BigDecimal],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp,
    taxDuePremium: Option[String],
    taxDueNpv: Option[String],
    honestyDeclaration: Option[String]
  )

  /** GetResult implicit for fetching TaxCalculationRow objects using plain SQL queries */
  implicit def GetResultTaxCalculationRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[String]],
    e2: GR[Option[scala.math.BigDecimal]],
    e3: GR[java.sql.Timestamp]
  ): GR[TaxCalculationRow] = GR { prs =>
    import prs._
    (TaxCalculationRow.apply _).tupled(
      (
        <<[scala.math.BigDecimal],
        <<[scala.math.BigDecimal],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[String],
        <<?[String],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<[java.sql.Timestamp],
        <<[java.sql.Timestamp],
        <<?[String],
        <<?[String],
        <<?[String]
      )
    )
  }

  /** Table description of table TAX_CALCULATION. Objects of this class serve as prototypes for rows in queries. */
  class TaxCalculation(_tableTag: Tag)
      extends profile.api.Table[TaxCalculationRow](_tableTag, Some("SDLT_FILE_DATA"), "TAX_CALCULATION") {
    def * = (
      (
        taxCalculationId,
        returnId,
        amountPaid,
        includesPenalty,
        taxDue,
        calcPenaltyDue,
        calcTaxDue,
        calcTaxRate1,
        calcTaxRate2,
        calcTotalTaxPenaltyDue,
        calcTotalNpvTax,
        calcTotalPremiumTax,
        lMigrated,
        createDate,
        lastUpdateDate,
        taxDuePremium,
        taxDueNpv,
        honestyDeclaration
      )
    ).mapTo[TaxCalculationRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(taxCalculationId),
        Rep.Some(returnId),
        amountPaid,
        includesPenalty,
        taxDue,
        calcPenaltyDue,
        calcTaxDue,
        calcTaxRate1,
        calcTaxRate2,
        calcTotalTaxPenaltyDue,
        calcTotalNpvTax,
        calcTotalPremiumTax,
        lMigrated,
        Rep.Some(createDate),
        Rep.Some(lastUpdateDate),
        taxDuePremium,
        taxDueNpv,
        honestyDeclaration
      )
    ).shaped.<>(
      { r =>
        import r._;
        _1.map(_ =>
          (TaxCalculationRow.apply _)
            .tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14.get, _15.get, _16, _17, _18))
        )
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column TAX_CALCULATION_ID SqlType(NUMBER), PrimaryKey */
    val taxCalculationId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("TAX_CALCULATION_ID", O.PrimaryKey)

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column AMOUNT_PAID SqlType(VARCHAR2), Length(500,true) */
    val amountPaid: Rep[Option[String]] = column[Option[String]]("AMOUNT_PAID", O.Length(500, varying = true))

    /** Database column INCLUDES_PENALTY SqlType(VARCHAR2), Length(3,true) */
    val includesPenalty: Rep[Option[String]] = column[Option[String]]("INCLUDES_PENALTY", O.Length(3, varying = true))

    /** Database column TAX_DUE SqlType(VARCHAR2), Length(500,true) */
    val taxDue: Rep[Option[String]] = column[Option[String]]("TAX_DUE", O.Length(500, varying = true))

    /** Database column CALC_PENALTY_DUE SqlType(NUMBER) */
    val calcPenaltyDue: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("CALC_PENALTY_DUE")

    /** Database column CALC_TAX_DUE SqlType(NUMBER) */
    val calcTaxDue: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("CALC_TAX_DUE")

    /** Database column CALC_TAX_RATE1 SqlType(VARCHAR2), Length(500,true) */
    val calcTaxRate1: Rep[Option[String]] = column[Option[String]]("CALC_TAX_RATE1", O.Length(500, varying = true))

    /** Database column CALC_TAX_RATE2 SqlType(VARCHAR2), Length(500,true) */
    val calcTaxRate2: Rep[Option[String]] = column[Option[String]]("CALC_TAX_RATE2", O.Length(500, varying = true))

    /** Database column CALC_TOTAL_TAX_PENALTY_DUE SqlType(NUMBER) */
    val calcTotalTaxPenaltyDue: Rep[Option[scala.math.BigDecimal]] =
      column[Option[scala.math.BigDecimal]]("CALC_TOTAL_TAX_PENALTY_DUE")

    /** Database column CALC_TOTAL_NPV_TAX SqlType(NUMBER) */
    val calcTotalNpvTax: Rep[Option[scala.math.BigDecimal]] =
      column[Option[scala.math.BigDecimal]]("CALC_TOTAL_NPV_TAX")

    /** Database column CALC_TOTAL_PREMIUM_TAX SqlType(NUMBER) */
    val calcTotalPremiumTax: Rep[Option[scala.math.BigDecimal]] =
      column[Option[scala.math.BigDecimal]]("CALC_TOTAL_PREMIUM_TAX")

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")

    /** Database column TAX_DUE_PREMIUM SqlType(VARCHAR2), Length(500,true) */
    val taxDuePremium: Rep[Option[String]] = column[Option[String]]("TAX_DUE_PREMIUM", O.Length(500, varying = true))

    /** Database column TAX_DUE_NPV SqlType(VARCHAR2), Length(500,true) */
    val taxDueNpv: Rep[Option[String]] = column[Option[String]]("TAX_DUE_NPV", O.Length(500, varying = true))

    /** Database column HONESTY_DECLARATION SqlType(VARCHAR2), Length(3,true) */
    val honestyDeclaration: Rep[Option[String]] =
      column[Option[String]]("HONESTY_DECLARATION", O.Length(3, varying = true))

    /** Foreign key referencing Return (database name TAX_CALCULATION_RETURN_FK) */
    lazy val returnFk = foreignKey("TAX_CALCULATION_RETURN_FK", returnId, Return)(
      r => r.returnId,
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )
  }

  /** Collection-like TableQuery object for table TaxCalculation */
  lazy val TaxCalculation = new TableQuery(tag => new TaxCalculation(tag))

  /** Entity class storing rows of table TaxCalculationBackup
    * @param taxCalculationId
    *   Database column TAX_CALCULATION_ID SqlType(NUMBER)
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param amountPaid
    *   Database column AMOUNT_PAID SqlType(VARCHAR2), Length(500,true)
    * @param includesPenalty
    *   Database column INCLUDES_PENALTY SqlType(VARCHAR2), Length(3,true)
    * @param taxDue
    *   Database column TAX_DUE SqlType(VARCHAR2), Length(500,true)
    * @param calcPenaltyDue
    *   Database column CALC_PENALTY_DUE SqlType(NUMBER)
    * @param calcTaxDue
    *   Database column CALC_TAX_DUE SqlType(NUMBER)
    * @param calcTaxRate1
    *   Database column CALC_TAX_RATE1 SqlType(VARCHAR2), Length(500,true)
    * @param calcTaxRate2
    *   Database column CALC_TAX_RATE2 SqlType(VARCHAR2), Length(500,true)
    * @param calcTotalTaxPenaltyDue
    *   Database column CALC_TOTAL_TAX_PENALTY_DUE SqlType(NUMBER)
    * @param calcTotalNpvTax
    *   Database column CALC_TOTAL_NPV_TAX SqlType(NUMBER)
    * @param calcTotalPremiumTax
    *   Database column CALC_TOTAL_PREMIUM_TAX SqlType(NUMBER)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    * @param taxDuePremium
    *   Database column TAX_DUE_PREMIUM SqlType(VARCHAR2), Length(500,true)
    * @param taxDueNpv
    *   Database column TAX_DUE_NPV SqlType(VARCHAR2), Length(500,true)
    * @param honestyDeclaration
    *   Database column HONESTY_DECLARATION SqlType(VARCHAR2), Length(3,true)
    */
  case class TaxCalculationBackupRow(
    taxCalculationId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    amountPaid: Option[String],
    includesPenalty: Option[String],
    taxDue: Option[String],
    calcPenaltyDue: Option[scala.math.BigDecimal],
    calcTaxDue: Option[scala.math.BigDecimal],
    calcTaxRate1: Option[String],
    calcTaxRate2: Option[String],
    calcTotalTaxPenaltyDue: Option[scala.math.BigDecimal],
    calcTotalNpvTax: Option[scala.math.BigDecimal],
    calcTotalPremiumTax: Option[scala.math.BigDecimal],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp,
    taxDuePremium: Option[String],
    taxDueNpv: Option[String],
    honestyDeclaration: Option[String]
  )

  /** GetResult implicit for fetching TaxCalculationBackupRow objects using plain SQL queries */
  implicit def GetResultTaxCalculationBackupRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[String]],
    e2: GR[Option[scala.math.BigDecimal]],
    e3: GR[java.sql.Timestamp]
  ): GR[TaxCalculationBackupRow] = GR { prs =>
    import prs._
    (TaxCalculationBackupRow.apply _).tupled(
      (
        <<[scala.math.BigDecimal],
        <<[scala.math.BigDecimal],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[String],
        <<?[String],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<[java.sql.Timestamp],
        <<[java.sql.Timestamp],
        <<?[String],
        <<?[String],
        <<?[String]
      )
    )
  }

  /** Table description of table TAX_CALCULATION_BACKUP. Objects of this class serve as prototypes for rows in queries.
    */
  class TaxCalculationBackup(_tableTag: Tag)
      extends profile.api.Table[TaxCalculationBackupRow](_tableTag, Some("SDLT_FILE_DATA"), "TAX_CALCULATION_BACKUP") {
    def * = (
      (
        taxCalculationId,
        returnId,
        amountPaid,
        includesPenalty,
        taxDue,
        calcPenaltyDue,
        calcTaxDue,
        calcTaxRate1,
        calcTaxRate2,
        calcTotalTaxPenaltyDue,
        calcTotalNpvTax,
        calcTotalPremiumTax,
        lMigrated,
        createDate,
        lastUpdateDate,
        taxDuePremium,
        taxDueNpv,
        honestyDeclaration
      )
    ).mapTo[TaxCalculationBackupRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(taxCalculationId),
        Rep.Some(returnId),
        amountPaid,
        includesPenalty,
        taxDue,
        calcPenaltyDue,
        calcTaxDue,
        calcTaxRate1,
        calcTaxRate2,
        calcTotalTaxPenaltyDue,
        calcTotalNpvTax,
        calcTotalPremiumTax,
        lMigrated,
        Rep.Some(createDate),
        Rep.Some(lastUpdateDate),
        taxDuePremium,
        taxDueNpv,
        honestyDeclaration
      )
    ).shaped.<>(
      { r =>
        import r._;
        _1.map(_ =>
          (TaxCalculationBackupRow.apply _)
            .tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14.get, _15.get, _16, _17, _18))
        )
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column TAX_CALCULATION_ID SqlType(NUMBER) */
    val taxCalculationId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("TAX_CALCULATION_ID")

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column AMOUNT_PAID SqlType(VARCHAR2), Length(500,true) */
    val amountPaid: Rep[Option[String]] = column[Option[String]]("AMOUNT_PAID", O.Length(500, varying = true))

    /** Database column INCLUDES_PENALTY SqlType(VARCHAR2), Length(3,true) */
    val includesPenalty: Rep[Option[String]] = column[Option[String]]("INCLUDES_PENALTY", O.Length(3, varying = true))

    /** Database column TAX_DUE SqlType(VARCHAR2), Length(500,true) */
    val taxDue: Rep[Option[String]] = column[Option[String]]("TAX_DUE", O.Length(500, varying = true))

    /** Database column CALC_PENALTY_DUE SqlType(NUMBER) */
    val calcPenaltyDue: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("CALC_PENALTY_DUE")

    /** Database column CALC_TAX_DUE SqlType(NUMBER) */
    val calcTaxDue: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("CALC_TAX_DUE")

    /** Database column CALC_TAX_RATE1 SqlType(VARCHAR2), Length(500,true) */
    val calcTaxRate1: Rep[Option[String]] = column[Option[String]]("CALC_TAX_RATE1", O.Length(500, varying = true))

    /** Database column CALC_TAX_RATE2 SqlType(VARCHAR2), Length(500,true) */
    val calcTaxRate2: Rep[Option[String]] = column[Option[String]]("CALC_TAX_RATE2", O.Length(500, varying = true))

    /** Database column CALC_TOTAL_TAX_PENALTY_DUE SqlType(NUMBER) */
    val calcTotalTaxPenaltyDue: Rep[Option[scala.math.BigDecimal]] =
      column[Option[scala.math.BigDecimal]]("CALC_TOTAL_TAX_PENALTY_DUE")

    /** Database column CALC_TOTAL_NPV_TAX SqlType(NUMBER) */
    val calcTotalNpvTax: Rep[Option[scala.math.BigDecimal]] =
      column[Option[scala.math.BigDecimal]]("CALC_TOTAL_NPV_TAX")

    /** Database column CALC_TOTAL_PREMIUM_TAX SqlType(NUMBER) */
    val calcTotalPremiumTax: Rep[Option[scala.math.BigDecimal]] =
      column[Option[scala.math.BigDecimal]]("CALC_TOTAL_PREMIUM_TAX")

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")

    /** Database column TAX_DUE_PREMIUM SqlType(VARCHAR2), Length(500,true) */
    val taxDuePremium: Rep[Option[String]] = column[Option[String]]("TAX_DUE_PREMIUM", O.Length(500, varying = true))

    /** Database column TAX_DUE_NPV SqlType(VARCHAR2), Length(500,true) */
    val taxDueNpv: Rep[Option[String]] = column[Option[String]]("TAX_DUE_NPV", O.Length(500, varying = true))

    /** Database column HONESTY_DECLARATION SqlType(VARCHAR2), Length(3,true) */
    val honestyDeclaration: Rep[Option[String]] =
      column[Option[String]]("HONESTY_DECLARATION", O.Length(3, varying = true))
  }

  /** Collection-like TableQuery object for table TaxCalculationBackup */
  lazy val TaxCalculationBackup = new TableQuery(tag => new TaxCalculationBackup(tag))

  /** Entity class storing rows of table Transaction
    * @param transactionId
    *   Database column TRANSACTION_ID SqlType(NUMBER), PrimaryKey
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param claimingRelief
    *   Database column CLAIMING_RELIEF SqlType(VARCHAR2), Length(500,true)
    * @param reliefAmount
    *   Database column RELIEF_AMOUNT SqlType(VARCHAR2), Length(500,true)
    * @param reliefReason
    *   Database column RELIEF_REASON SqlType(VARCHAR2), Length(500,true)
    * @param reliefSchemeNumber
    *   Database column RELIEF_SCHEME_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param isLinked
    *   Database column IS_LINKED SqlType(VARCHAR2), Length(3,true)
    * @param totalConsiderationLinked
    *   Database column TOTAL_CONSIDERATION_LINKED SqlType(VARCHAR2), Length(500,true)
    * @param totalConsideration
    *   Database column TOTAL_CONSIDERATION SqlType(VARCHAR2), Length(500,true)
    * @param considerationBuild
    *   Database column CONSIDERATION_BUILD SqlType(VARCHAR2), Length(3,true)
    * @param considerationCash
    *   Database column CONSIDERATION_CASH SqlType(VARCHAR2), Length(3,true)
    * @param considerationContingent
    *   Database column CONSIDERATION_CONTINGENT SqlType(VARCHAR2), Length(3,true)
    * @param considerationDebt
    *   Database column CONSIDERATION_DEBT SqlType(VARCHAR2), Length(3,true)
    * @param considerationEmploy
    *   Database column CONSIDERATION_EMPLOY SqlType(VARCHAR2), Length(3,true)
    * @param considerationOther
    *   Database column CONSIDERATION_OTHER SqlType(VARCHAR2), Length(3,true)
    * @param considerationLand
    *   Database column CONSIDERATION_LAND SqlType(VARCHAR2), Length(3,true)
    * @param considerationServices
    *   Database column CONSIDERATION_SERVICES SqlType(VARCHAR2), Length(3,true)
    * @param considerationSharesQtd
    *   Database column CONSIDERATION_SHARES_QTD SqlType(VARCHAR2), Length(3,true)
    * @param considerationSharesUnqtd
    *   Database column CONSIDERATION_SHARES_UNQTD SqlType(VARCHAR2), Length(3,true)
    * @param considerationVat
    *   Database column CONSIDERATION_VAT SqlType(VARCHAR2), Length(500,true)
    * @param includesChattel
    *   Database column INCLUDES_CHATTEL SqlType(VARCHAR2), Length(3,true)
    * @param includesGoodwill
    *   Database column INCLUDES_GOODWILL SqlType(VARCHAR2), Length(3,true)
    * @param includesOther
    *   Database column INCLUDES_OTHER SqlType(VARCHAR2), Length(3,true)
    * @param includesStock
    *   Database column INCLUDES_STOCK SqlType(VARCHAR2), Length(3,true)
    * @param usedAsFactory
    *   Database column USED_AS_FACTORY SqlType(VARCHAR2), Length(3,true)
    * @param usedAsHotel
    *   Database column USED_AS_HOTEL SqlType(VARCHAR2), Length(3,true)
    * @param usedAsIndustrial
    *   Database column USED_AS_INDUSTRIAL SqlType(VARCHAR2), Length(3,true)
    * @param usedAsOffice
    *   Database column USED_AS_OFFICE SqlType(VARCHAR2), Length(3,true)
    * @param usedAsOther
    *   Database column USED_AS_OTHER SqlType(VARCHAR2), Length(3,true)
    * @param usedAsShop
    *   Database column USED_AS_SHOP SqlType(VARCHAR2), Length(3,true)
    * @param usedAsWarehouse
    *   Database column USED_AS_WAREHOUSE SqlType(VARCHAR2), Length(3,true)
    * @param contractDate
    *   Database column CONTRACT_DATE SqlType(VARCHAR2), Length(500,true)
    * @param isDependantOnFutureEvent
    *   Database column IS_DEPENDANT_ON_FUTURE_EVENT SqlType(VARCHAR2), Length(3,true)
    * @param newTransactionDescription
    *   Database column NEW_TRANSACTION_DESCRIPTION SqlType(VARCHAR2), Length(500,true)
    * @param transactionDescription
    *   Database column TRANSACTION_DESCRIPTION SqlType(VARCHAR2), Length(500,true)
    * @param effectiveDate
    *   Database column EFFECTIVE_DATE SqlType(VARCHAR2), Length(500,true)
    * @param isLandExchanged
    *   Database column IS_LAND_EXCHANGED SqlType(VARCHAR2), Length(3,true)
    * @param exchangedLandHouseNumber
    *   Database column EXCHANGED_LAND_HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param exchangedLandAddress1
    *   Database column EXCHANGED_LAND_ADDRESS_1 SqlType(VARCHAR2), Length(500,true)
    * @param exchangedLandAddress2
    *   Database column EXCHANGED_LAND_ADDRESS_2 SqlType(VARCHAR2), Length(500,true)
    * @param exchangedLandAddress3
    *   Database column EXCHANGED_LAND_ADDRESS_3 SqlType(VARCHAR2), Length(500,true)
    * @param exchangedLandAddress4
    *   Database column EXCHANGED_LAND_ADDRESS_4 SqlType(VARCHAR2), Length(500,true)
    * @param exchangedLandPostcode
    *   Database column EXCHANGED_LAND_POSTCODE SqlType(VARCHAR2), Length(500,true)
    * @param agreedToDeferPayment
    *   Database column AGREED_TO_DEFER_PAYMENT SqlType(VARCHAR2), Length(3,true)
    * @param postTransRulingApplied
    *   Database column POST_TRANS_RULING_APPLIED SqlType(VARCHAR2), Length(3,true)
    * @param isPursuantToPreviousOption
    *   Database column IS_PURSUANT_TO_PREVIOUS_OPTION SqlType(VARCHAR2), Length(3,true)
    * @param restrictionsAffectInterest
    *   Database column RESTRICTIONS_AFFECT_INTEREST SqlType(VARCHAR2), Length(3,true)
    * @param restrictionDetails
    *   Database column RESTRICTION_DETAILS SqlType(VARCHAR2), Length(500,true)
    * @param postTransRulingFollowed
    *   Database column POST_TRANS_RULING_FOLLOWED SqlType(VARCHAR2), Length(500,true)
    * @param isPartOfSaleOfBusiness
    *   Database column IS_PART_OF_SALE_OF_BUSINESS SqlType(VARCHAR2), Length(3,true)
    * @param totalConsiderationBusiness
    *   Database column TOTAL_CONSIDERATION_BUSINESS SqlType(VARCHAR2), Length(500,true)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    */
  case class TransactionRow(
    transactionId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    claimingRelief: Option[String],
    reliefAmount: Option[String],
    reliefReason: Option[String],
    reliefSchemeNumber: Option[String],
    isLinked: Option[String],
    totalConsiderationLinked: Option[String],
    totalConsideration: Option[String],
    considerationBuild: Option[String],
    considerationCash: Option[String],
    considerationContingent: Option[String],
    considerationDebt: Option[String],
    considerationEmploy: Option[String],
    considerationOther: Option[String],
    considerationLand: Option[String],
    considerationServices: Option[String],
    considerationSharesQtd: Option[String],
    considerationSharesUnqtd: Option[String],
    considerationVat: Option[String],
    includesChattel: Option[String],
    includesGoodwill: Option[String],
    includesOther: Option[String],
    includesStock: Option[String],
    usedAsFactory: Option[String],
    usedAsHotel: Option[String],
    usedAsIndustrial: Option[String],
    usedAsOffice: Option[String],
    usedAsOther: Option[String],
    usedAsShop: Option[String],
    usedAsWarehouse: Option[String],
    contractDate: Option[String],
    isDependantOnFutureEvent: Option[String],
    newTransactionDescription: Option[String],
    transactionDescription: Option[String],
    effectiveDate: Option[String],
    isLandExchanged: Option[String],
    exchangedLandHouseNumber: Option[String],
    exchangedLandAddress1: Option[String],
    exchangedLandAddress2: Option[String],
    exchangedLandAddress3: Option[String],
    exchangedLandAddress4: Option[String],
    exchangedLandPostcode: Option[String],
    agreedToDeferPayment: Option[String],
    postTransRulingApplied: Option[String],
    isPursuantToPreviousOption: Option[String],
    restrictionsAffectInterest: Option[String],
    restrictionDetails: Option[String],
    postTransRulingFollowed: Option[String],
    isPartOfSaleOfBusiness: Option[String],
    totalConsiderationBusiness: Option[String],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp
  )

  /** GetResult implicit for fetching TransactionRow objects using plain SQL queries */
  implicit def GetResultTransactionRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[String]],
    e2: GR[Option[scala.math.BigDecimal]],
    e3: GR[java.sql.Timestamp]
  ): GR[TransactionRow] = GR { prs =>
    import prs._
    TransactionRow(
      <<[scala.math.BigDecimal],
      <<[scala.math.BigDecimal],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[scala.math.BigDecimal],
      <<[java.sql.Timestamp],
      <<[java.sql.Timestamp]
    )
  }

  /** Table description of table TRANSACTION. Objects of this class serve as prototypes for rows in queries. */
  class Transaction(_tableTag: Tag)
      extends profile.api.Table[TransactionRow](_tableTag, Some("SDLT_FILE_DATA"), "TRANSACTION") {
    def * =
      (transactionId :: returnId :: claimingRelief :: reliefAmount :: reliefReason :: reliefSchemeNumber :: isLinked :: totalConsiderationLinked :: totalConsideration :: considerationBuild :: considerationCash :: considerationContingent :: considerationDebt :: considerationEmploy :: considerationOther :: considerationLand :: considerationServices :: considerationSharesQtd :: considerationSharesUnqtd :: considerationVat :: includesChattel :: includesGoodwill :: includesOther :: includesStock :: usedAsFactory :: usedAsHotel :: usedAsIndustrial :: usedAsOffice :: usedAsOther :: usedAsShop :: usedAsWarehouse :: contractDate :: isDependantOnFutureEvent :: newTransactionDescription :: transactionDescription :: effectiveDate :: isLandExchanged :: exchangedLandHouseNumber :: exchangedLandAddress1 :: exchangedLandAddress2 :: exchangedLandAddress3 :: exchangedLandAddress4 :: exchangedLandPostcode :: agreedToDeferPayment :: postTransRulingApplied :: isPursuantToPreviousOption :: restrictionsAffectInterest :: restrictionDetails :: postTransRulingFollowed :: isPartOfSaleOfBusiness :: totalConsiderationBusiness :: lMigrated :: createDate :: lastUpdateDate :: HNil)
        .mapTo[TransactionRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(transactionId) :: Rep.Some(
      returnId
    ) :: claimingRelief :: reliefAmount :: reliefReason :: reliefSchemeNumber :: isLinked :: totalConsiderationLinked :: totalConsideration :: considerationBuild :: considerationCash :: considerationContingent :: considerationDebt :: considerationEmploy :: considerationOther :: considerationLand :: considerationServices :: considerationSharesQtd :: considerationSharesUnqtd :: considerationVat :: includesChattel :: includesGoodwill :: includesOther :: includesStock :: usedAsFactory :: usedAsHotel :: usedAsIndustrial :: usedAsOffice :: usedAsOther :: usedAsShop :: usedAsWarehouse :: contractDate :: isDependantOnFutureEvent :: newTransactionDescription :: transactionDescription :: effectiveDate :: isLandExchanged :: exchangedLandHouseNumber :: exchangedLandAddress1 :: exchangedLandAddress2 :: exchangedLandAddress3 :: exchangedLandAddress4 :: exchangedLandPostcode :: agreedToDeferPayment :: postTransRulingApplied :: isPursuantToPreviousOption :: restrictionsAffectInterest :: restrictionDetails :: postTransRulingFollowed :: isPartOfSaleOfBusiness :: totalConsiderationBusiness :: lMigrated :: Rep
      .Some(createDate) :: Rep.Some(lastUpdateDate) :: HNil).shaped.<>(
      r =>
        TransactionRow(
          r.productElement(0).asInstanceOf[Option[scala.math.BigDecimal]].get,
          r.productElement(1).asInstanceOf[Option[scala.math.BigDecimal]].get,
          r.productElement(2).asInstanceOf[Option[String]],
          r.productElement(3).asInstanceOf[Option[String]],
          r.productElement(4).asInstanceOf[Option[String]],
          r.productElement(5).asInstanceOf[Option[String]],
          r.productElement(6).asInstanceOf[Option[String]],
          r.productElement(7).asInstanceOf[Option[String]],
          r.productElement(8).asInstanceOf[Option[String]],
          r.productElement(9).asInstanceOf[Option[String]],
          r.productElement(10).asInstanceOf[Option[String]],
          r.productElement(11).asInstanceOf[Option[String]],
          r.productElement(12).asInstanceOf[Option[String]],
          r.productElement(13).asInstanceOf[Option[String]],
          r.productElement(14).asInstanceOf[Option[String]],
          r.productElement(15).asInstanceOf[Option[String]],
          r.productElement(16).asInstanceOf[Option[String]],
          r.productElement(17).asInstanceOf[Option[String]],
          r.productElement(18).asInstanceOf[Option[String]],
          r.productElement(19).asInstanceOf[Option[String]],
          r.productElement(20).asInstanceOf[Option[String]],
          r.productElement(21).asInstanceOf[Option[String]],
          r.productElement(22).asInstanceOf[Option[String]],
          r.productElement(23).asInstanceOf[Option[String]],
          r.productElement(24).asInstanceOf[Option[String]],
          r.productElement(25).asInstanceOf[Option[String]],
          r.productElement(26).asInstanceOf[Option[String]],
          r.productElement(27).asInstanceOf[Option[String]],
          r.productElement(28).asInstanceOf[Option[String]],
          r.productElement(29).asInstanceOf[Option[String]],
          r.productElement(30).asInstanceOf[Option[String]],
          r.productElement(31).asInstanceOf[Option[String]],
          r.productElement(32).asInstanceOf[Option[String]],
          r.productElement(33).asInstanceOf[Option[String]],
          r.productElement(34).asInstanceOf[Option[String]],
          r.productElement(35).asInstanceOf[Option[String]],
          r.productElement(36).asInstanceOf[Option[String]],
          r.productElement(37).asInstanceOf[Option[String]],
          r.productElement(38).asInstanceOf[Option[String]],
          r.productElement(39).asInstanceOf[Option[String]],
          r.productElement(40).asInstanceOf[Option[String]],
          r.productElement(41).asInstanceOf[Option[String]],
          r.productElement(42).asInstanceOf[Option[String]],
          r.productElement(43).asInstanceOf[Option[String]],
          r.productElement(44).asInstanceOf[Option[String]],
          r.productElement(45).asInstanceOf[Option[String]],
          r.productElement(46).asInstanceOf[Option[String]],
          r.productElement(47).asInstanceOf[Option[String]],
          r.productElement(48).asInstanceOf[Option[String]],
          r.productElement(49).asInstanceOf[Option[String]],
          r.productElement(50).asInstanceOf[Option[String]],
          r.productElement(51).asInstanceOf[Option[scala.math.BigDecimal]],
          r.productElement(52).asInstanceOf[Option[java.sql.Timestamp]].get,
          r.productElement(53).asInstanceOf[Option[java.sql.Timestamp]].get
        ),
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column TRANSACTION_ID SqlType(NUMBER), PrimaryKey */
    val transactionId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("TRANSACTION_ID", O.PrimaryKey)

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column CLAIMING_RELIEF SqlType(VARCHAR2), Length(500,true) */
    val claimingRelief: Rep[Option[String]] = column[Option[String]]("CLAIMING_RELIEF", O.Length(500, varying = true))

    /** Database column RELIEF_AMOUNT SqlType(VARCHAR2), Length(500,true) */
    val reliefAmount: Rep[Option[String]] = column[Option[String]]("RELIEF_AMOUNT", O.Length(500, varying = true))

    /** Database column RELIEF_REASON SqlType(VARCHAR2), Length(500,true) */
    val reliefReason: Rep[Option[String]] = column[Option[String]]("RELIEF_REASON", O.Length(500, varying = true))

    /** Database column RELIEF_SCHEME_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val reliefSchemeNumber: Rep[Option[String]] =
      column[Option[String]]("RELIEF_SCHEME_NUMBER", O.Length(500, varying = true))

    /** Database column IS_LINKED SqlType(VARCHAR2), Length(3,true) */
    val isLinked: Rep[Option[String]] = column[Option[String]]("IS_LINKED", O.Length(3, varying = true))

    /** Database column TOTAL_CONSIDERATION_LINKED SqlType(VARCHAR2), Length(500,true) */
    val totalConsiderationLinked: Rep[Option[String]] =
      column[Option[String]]("TOTAL_CONSIDERATION_LINKED", O.Length(500, varying = true))

    /** Database column TOTAL_CONSIDERATION SqlType(VARCHAR2), Length(500,true) */
    val totalConsideration: Rep[Option[String]] =
      column[Option[String]]("TOTAL_CONSIDERATION", O.Length(500, varying = true))

    /** Database column CONSIDERATION_BUILD SqlType(VARCHAR2), Length(3,true) */
    val considerationBuild: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_BUILD", O.Length(3, varying = true))

    /** Database column CONSIDERATION_CASH SqlType(VARCHAR2), Length(3,true) */
    val considerationCash: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_CASH", O.Length(3, varying = true))

    /** Database column CONSIDERATION_CONTINGENT SqlType(VARCHAR2), Length(3,true) */
    val considerationContingent: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_CONTINGENT", O.Length(3, varying = true))

    /** Database column CONSIDERATION_DEBT SqlType(VARCHAR2), Length(3,true) */
    val considerationDebt: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_DEBT", O.Length(3, varying = true))

    /** Database column CONSIDERATION_EMPLOY SqlType(VARCHAR2), Length(3,true) */
    val considerationEmploy: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_EMPLOY", O.Length(3, varying = true))

    /** Database column CONSIDERATION_OTHER SqlType(VARCHAR2), Length(3,true) */
    val considerationOther: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_OTHER", O.Length(3, varying = true))

    /** Database column CONSIDERATION_LAND SqlType(VARCHAR2), Length(3,true) */
    val considerationLand: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_LAND", O.Length(3, varying = true))

    /** Database column CONSIDERATION_SERVICES SqlType(VARCHAR2), Length(3,true) */
    val considerationServices: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_SERVICES", O.Length(3, varying = true))

    /** Database column CONSIDERATION_SHARES_QTD SqlType(VARCHAR2), Length(3,true) */
    val considerationSharesQtd: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_SHARES_QTD", O.Length(3, varying = true))

    /** Database column CONSIDERATION_SHARES_UNQTD SqlType(VARCHAR2), Length(3,true) */
    val considerationSharesUnqtd: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_SHARES_UNQTD", O.Length(3, varying = true))

    /** Database column CONSIDERATION_VAT SqlType(VARCHAR2), Length(500,true) */
    val considerationVat: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_VAT", O.Length(500, varying = true))

    /** Database column INCLUDES_CHATTEL SqlType(VARCHAR2), Length(3,true) */
    val includesChattel: Rep[Option[String]] = column[Option[String]]("INCLUDES_CHATTEL", O.Length(3, varying = true))

    /** Database column INCLUDES_GOODWILL SqlType(VARCHAR2), Length(3,true) */
    val includesGoodwill: Rep[Option[String]] = column[Option[String]]("INCLUDES_GOODWILL", O.Length(3, varying = true))

    /** Database column INCLUDES_OTHER SqlType(VARCHAR2), Length(3,true) */
    val includesOther: Rep[Option[String]] = column[Option[String]]("INCLUDES_OTHER", O.Length(3, varying = true))

    /** Database column INCLUDES_STOCK SqlType(VARCHAR2), Length(3,true) */
    val includesStock: Rep[Option[String]] = column[Option[String]]("INCLUDES_STOCK", O.Length(3, varying = true))

    /** Database column USED_AS_FACTORY SqlType(VARCHAR2), Length(3,true) */
    val usedAsFactory: Rep[Option[String]] = column[Option[String]]("USED_AS_FACTORY", O.Length(3, varying = true))

    /** Database column USED_AS_HOTEL SqlType(VARCHAR2), Length(3,true) */
    val usedAsHotel: Rep[Option[String]] = column[Option[String]]("USED_AS_HOTEL", O.Length(3, varying = true))

    /** Database column USED_AS_INDUSTRIAL SqlType(VARCHAR2), Length(3,true) */
    val usedAsIndustrial: Rep[Option[String]] =
      column[Option[String]]("USED_AS_INDUSTRIAL", O.Length(3, varying = true))

    /** Database column USED_AS_OFFICE SqlType(VARCHAR2), Length(3,true) */
    val usedAsOffice: Rep[Option[String]] = column[Option[String]]("USED_AS_OFFICE", O.Length(3, varying = true))

    /** Database column USED_AS_OTHER SqlType(VARCHAR2), Length(3,true) */
    val usedAsOther: Rep[Option[String]] = column[Option[String]]("USED_AS_OTHER", O.Length(3, varying = true))

    /** Database column USED_AS_SHOP SqlType(VARCHAR2), Length(3,true) */
    val usedAsShop: Rep[Option[String]] = column[Option[String]]("USED_AS_SHOP", O.Length(3, varying = true))

    /** Database column USED_AS_WAREHOUSE SqlType(VARCHAR2), Length(3,true) */
    val usedAsWarehouse: Rep[Option[String]] = column[Option[String]]("USED_AS_WAREHOUSE", O.Length(3, varying = true))

    /** Database column CONTRACT_DATE SqlType(VARCHAR2), Length(500,true) */
    val contractDate: Rep[Option[String]] = column[Option[String]]("CONTRACT_DATE", O.Length(500, varying = true))

    /** Database column IS_DEPENDANT_ON_FUTURE_EVENT SqlType(VARCHAR2), Length(3,true) */
    val isDependantOnFutureEvent: Rep[Option[String]] =
      column[Option[String]]("IS_DEPENDANT_ON_FUTURE_EVENT", O.Length(3, varying = true))

    /** Database column NEW_TRANSACTION_DESCRIPTION SqlType(VARCHAR2), Length(500,true) */
    val newTransactionDescription: Rep[Option[String]] =
      column[Option[String]]("NEW_TRANSACTION_DESCRIPTION", O.Length(500, varying = true))

    /** Database column TRANSACTION_DESCRIPTION SqlType(VARCHAR2), Length(500,true) */
    val transactionDescription: Rep[Option[String]] =
      column[Option[String]]("TRANSACTION_DESCRIPTION", O.Length(500, varying = true))

    /** Database column EFFECTIVE_DATE SqlType(VARCHAR2), Length(500,true) */
    val effectiveDate: Rep[Option[String]] = column[Option[String]]("EFFECTIVE_DATE", O.Length(500, varying = true))

    /** Database column IS_LAND_EXCHANGED SqlType(VARCHAR2), Length(3,true) */
    val isLandExchanged: Rep[Option[String]] = column[Option[String]]("IS_LAND_EXCHANGED", O.Length(3, varying = true))

    /** Database column EXCHANGED_LAND_HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val exchangedLandHouseNumber: Rep[Option[String]] =
      column[Option[String]]("EXCHANGED_LAND_HOUSE_NUMBER", O.Length(500, varying = true))

    /** Database column EXCHANGED_LAND_ADDRESS_1 SqlType(VARCHAR2), Length(500,true) */
    val exchangedLandAddress1: Rep[Option[String]] =
      column[Option[String]]("EXCHANGED_LAND_ADDRESS_1", O.Length(500, varying = true))

    /** Database column EXCHANGED_LAND_ADDRESS_2 SqlType(VARCHAR2), Length(500,true) */
    val exchangedLandAddress2: Rep[Option[String]] =
      column[Option[String]]("EXCHANGED_LAND_ADDRESS_2", O.Length(500, varying = true))

    /** Database column EXCHANGED_LAND_ADDRESS_3 SqlType(VARCHAR2), Length(500,true) */
    val exchangedLandAddress3: Rep[Option[String]] =
      column[Option[String]]("EXCHANGED_LAND_ADDRESS_3", O.Length(500, varying = true))

    /** Database column EXCHANGED_LAND_ADDRESS_4 SqlType(VARCHAR2), Length(500,true) */
    val exchangedLandAddress4: Rep[Option[String]] =
      column[Option[String]]("EXCHANGED_LAND_ADDRESS_4", O.Length(500, varying = true))

    /** Database column EXCHANGED_LAND_POSTCODE SqlType(VARCHAR2), Length(500,true) */
    val exchangedLandPostcode: Rep[Option[String]] =
      column[Option[String]]("EXCHANGED_LAND_POSTCODE", O.Length(500, varying = true))

    /** Database column AGREED_TO_DEFER_PAYMENT SqlType(VARCHAR2), Length(3,true) */
    val agreedToDeferPayment: Rep[Option[String]] =
      column[Option[String]]("AGREED_TO_DEFER_PAYMENT", O.Length(3, varying = true))

    /** Database column POST_TRANS_RULING_APPLIED SqlType(VARCHAR2), Length(3,true) */
    val postTransRulingApplied: Rep[Option[String]] =
      column[Option[String]]("POST_TRANS_RULING_APPLIED", O.Length(3, varying = true))

    /** Database column IS_PURSUANT_TO_PREVIOUS_OPTION SqlType(VARCHAR2), Length(3,true) */
    val isPursuantToPreviousOption: Rep[Option[String]] =
      column[Option[String]]("IS_PURSUANT_TO_PREVIOUS_OPTION", O.Length(3, varying = true))

    /** Database column RESTRICTIONS_AFFECT_INTEREST SqlType(VARCHAR2), Length(3,true) */
    val restrictionsAffectInterest: Rep[Option[String]] =
      column[Option[String]]("RESTRICTIONS_AFFECT_INTEREST", O.Length(3, varying = true))

    /** Database column RESTRICTION_DETAILS SqlType(VARCHAR2), Length(500,true) */
    val restrictionDetails: Rep[Option[String]] =
      column[Option[String]]("RESTRICTION_DETAILS", O.Length(500, varying = true))

    /** Database column POST_TRANS_RULING_FOLLOWED SqlType(VARCHAR2), Length(500,true) */
    val postTransRulingFollowed: Rep[Option[String]] =
      column[Option[String]]("POST_TRANS_RULING_FOLLOWED", O.Length(500, varying = true))

    /** Database column IS_PART_OF_SALE_OF_BUSINESS SqlType(VARCHAR2), Length(3,true) */
    val isPartOfSaleOfBusiness: Rep[Option[String]] =
      column[Option[String]]("IS_PART_OF_SALE_OF_BUSINESS", O.Length(3, varying = true))

    /** Database column TOTAL_CONSIDERATION_BUSINESS SqlType(VARCHAR2), Length(500,true) */
    val totalConsiderationBusiness: Rep[Option[String]] =
      column[Option[String]]("TOTAL_CONSIDERATION_BUSINESS", O.Length(500, varying = true))

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")

    /** Foreign key referencing Return (database name TRANSACTION_RETURN_FK) */
    lazy val returnFk = foreignKey("TRANSACTION_RETURN_FK", returnId :: HNil, Return)(
      r => r.returnId :: HNil,
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )
  }

  /** Collection-like TableQuery object for table Transaction */
  lazy val Transaction = new TableQuery(tag => new Transaction(tag))

  /** Entity class storing rows of table TransactionBackup
    * @param transactionId
    *   Database column TRANSACTION_ID SqlType(NUMBER)
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param claimingRelief
    *   Database column CLAIMING_RELIEF SqlType(VARCHAR2), Length(500,true)
    * @param reliefAmount
    *   Database column RELIEF_AMOUNT SqlType(VARCHAR2), Length(500,true)
    * @param reliefReason
    *   Database column RELIEF_REASON SqlType(VARCHAR2), Length(500,true)
    * @param reliefSchemeNumber
    *   Database column RELIEF_SCHEME_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param isLinked
    *   Database column IS_LINKED SqlType(VARCHAR2), Length(3,true)
    * @param totalConsiderationLinked
    *   Database column TOTAL_CONSIDERATION_LINKED SqlType(VARCHAR2), Length(500,true)
    * @param totalConsideration
    *   Database column TOTAL_CONSIDERATION SqlType(VARCHAR2), Length(500,true)
    * @param considerationBuild
    *   Database column CONSIDERATION_BUILD SqlType(VARCHAR2), Length(3,true)
    * @param considerationCash
    *   Database column CONSIDERATION_CASH SqlType(VARCHAR2), Length(3,true)
    * @param considerationContingent
    *   Database column CONSIDERATION_CONTINGENT SqlType(VARCHAR2), Length(3,true)
    * @param considerationDebt
    *   Database column CONSIDERATION_DEBT SqlType(VARCHAR2), Length(3,true)
    * @param considerationEmploy
    *   Database column CONSIDERATION_EMPLOY SqlType(VARCHAR2), Length(3,true)
    * @param considerationOther
    *   Database column CONSIDERATION_OTHER SqlType(VARCHAR2), Length(3,true)
    * @param considerationLand
    *   Database column CONSIDERATION_LAND SqlType(VARCHAR2), Length(3,true)
    * @param considerationServices
    *   Database column CONSIDERATION_SERVICES SqlType(VARCHAR2), Length(3,true)
    * @param considerationSharesQtd
    *   Database column CONSIDERATION_SHARES_QTD SqlType(VARCHAR2), Length(3,true)
    * @param considerationSharesUnqtd
    *   Database column CONSIDERATION_SHARES_UNQTD SqlType(VARCHAR2), Length(3,true)
    * @param considerationVat
    *   Database column CONSIDERATION_VAT SqlType(VARCHAR2), Length(500,true)
    * @param includesChattel
    *   Database column INCLUDES_CHATTEL SqlType(VARCHAR2), Length(3,true)
    * @param includesGoodwill
    *   Database column INCLUDES_GOODWILL SqlType(VARCHAR2), Length(3,true)
    * @param includesOther
    *   Database column INCLUDES_OTHER SqlType(VARCHAR2), Length(3,true)
    * @param includesStock
    *   Database column INCLUDES_STOCK SqlType(VARCHAR2), Length(3,true)
    * @param usedAsFactory
    *   Database column USED_AS_FACTORY SqlType(VARCHAR2), Length(3,true)
    * @param usedAsHotel
    *   Database column USED_AS_HOTEL SqlType(VARCHAR2), Length(3,true)
    * @param usedAsIndustrial
    *   Database column USED_AS_INDUSTRIAL SqlType(VARCHAR2), Length(3,true)
    * @param usedAsOffice
    *   Database column USED_AS_OFFICE SqlType(VARCHAR2), Length(3,true)
    * @param usedAsOther
    *   Database column USED_AS_OTHER SqlType(VARCHAR2), Length(3,true)
    * @param usedAsShop
    *   Database column USED_AS_SHOP SqlType(VARCHAR2), Length(3,true)
    * @param usedAsWarehouse
    *   Database column USED_AS_WAREHOUSE SqlType(VARCHAR2), Length(3,true)
    * @param contractDate
    *   Database column CONTRACT_DATE SqlType(VARCHAR2), Length(500,true)
    * @param isDependantOnFutureEvent
    *   Database column IS_DEPENDANT_ON_FUTURE_EVENT SqlType(VARCHAR2), Length(3,true)
    * @param newTransactionDescription
    *   Database column NEW_TRANSACTION_DESCRIPTION SqlType(VARCHAR2), Length(500,true)
    * @param transactionDescription
    *   Database column TRANSACTION_DESCRIPTION SqlType(VARCHAR2), Length(500,true)
    * @param effectiveDate
    *   Database column EFFECTIVE_DATE SqlType(VARCHAR2), Length(500,true)
    * @param isLandExchanged
    *   Database column IS_LAND_EXCHANGED SqlType(VARCHAR2), Length(3,true)
    * @param exchangedLandHouseNumber
    *   Database column EXCHANGED_LAND_HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param exchangedLandAddress1
    *   Database column EXCHANGED_LAND_ADDRESS_1 SqlType(VARCHAR2), Length(500,true)
    * @param exchangedLandAddress2
    *   Database column EXCHANGED_LAND_ADDRESS_2 SqlType(VARCHAR2), Length(500,true)
    * @param exchangedLandAddress3
    *   Database column EXCHANGED_LAND_ADDRESS_3 SqlType(VARCHAR2), Length(500,true)
    * @param exchangedLandAddress4
    *   Database column EXCHANGED_LAND_ADDRESS_4 SqlType(VARCHAR2), Length(500,true)
    * @param exchangedLandPostcode
    *   Database column EXCHANGED_LAND_POSTCODE SqlType(VARCHAR2), Length(500,true)
    * @param agreedToDeferPayment
    *   Database column AGREED_TO_DEFER_PAYMENT SqlType(VARCHAR2), Length(3,true)
    * @param postTransRulingApplied
    *   Database column POST_TRANS_RULING_APPLIED SqlType(VARCHAR2), Length(3,true)
    * @param isPursuantToPreviousOption
    *   Database column IS_PURSUANT_TO_PREVIOUS_OPTION SqlType(VARCHAR2), Length(3,true)
    * @param restrictionsAffectInterest
    *   Database column RESTRICTIONS_AFFECT_INTEREST SqlType(VARCHAR2), Length(3,true)
    * @param restrictionDetails
    *   Database column RESTRICTION_DETAILS SqlType(VARCHAR2), Length(500,true)
    * @param postTransRulingFollowed
    *   Database column POST_TRANS_RULING_FOLLOWED SqlType(VARCHAR2), Length(500,true)
    * @param isPartOfSaleOfBusiness
    *   Database column IS_PART_OF_SALE_OF_BUSINESS SqlType(VARCHAR2), Length(3,true)
    * @param totalConsiderationBusiness
    *   Database column TOTAL_CONSIDERATION_BUSINESS SqlType(VARCHAR2), Length(500,true)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    */
  case class TransactionBackupRow(
    transactionId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    claimingRelief: Option[String],
    reliefAmount: Option[String],
    reliefReason: Option[String],
    reliefSchemeNumber: Option[String],
    isLinked: Option[String],
    totalConsiderationLinked: Option[String],
    totalConsideration: Option[String],
    considerationBuild: Option[String],
    considerationCash: Option[String],
    considerationContingent: Option[String],
    considerationDebt: Option[String],
    considerationEmploy: Option[String],
    considerationOther: Option[String],
    considerationLand: Option[String],
    considerationServices: Option[String],
    considerationSharesQtd: Option[String],
    considerationSharesUnqtd: Option[String],
    considerationVat: Option[String],
    includesChattel: Option[String],
    includesGoodwill: Option[String],
    includesOther: Option[String],
    includesStock: Option[String],
    usedAsFactory: Option[String],
    usedAsHotel: Option[String],
    usedAsIndustrial: Option[String],
    usedAsOffice: Option[String],
    usedAsOther: Option[String],
    usedAsShop: Option[String],
    usedAsWarehouse: Option[String],
    contractDate: Option[String],
    isDependantOnFutureEvent: Option[String],
    newTransactionDescription: Option[String],
    transactionDescription: Option[String],
    effectiveDate: Option[String],
    isLandExchanged: Option[String],
    exchangedLandHouseNumber: Option[String],
    exchangedLandAddress1: Option[String],
    exchangedLandAddress2: Option[String],
    exchangedLandAddress3: Option[String],
    exchangedLandAddress4: Option[String],
    exchangedLandPostcode: Option[String],
    agreedToDeferPayment: Option[String],
    postTransRulingApplied: Option[String],
    isPursuantToPreviousOption: Option[String],
    restrictionsAffectInterest: Option[String],
    restrictionDetails: Option[String],
    postTransRulingFollowed: Option[String],
    isPartOfSaleOfBusiness: Option[String],
    totalConsiderationBusiness: Option[String],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp
  )

  /** GetResult implicit for fetching TransactionBackupRow objects using plain SQL queries */
  implicit def GetResultTransactionBackupRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[String]],
    e2: GR[Option[scala.math.BigDecimal]],
    e3: GR[java.sql.Timestamp]
  ): GR[TransactionBackupRow] = GR { prs =>
    import prs._
    TransactionBackupRow(
      <<[scala.math.BigDecimal],
      <<[scala.math.BigDecimal],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[String],
      <<?[scala.math.BigDecimal],
      <<[java.sql.Timestamp],
      <<[java.sql.Timestamp]
    )
  }

  /** Table description of table TRANSACTION_BACKUP. Objects of this class serve as prototypes for rows in queries. */
  class TransactionBackup(_tableTag: Tag)
      extends profile.api.Table[TransactionBackupRow](_tableTag, Some("SDLT_FILE_DATA"), "TRANSACTION_BACKUP") {
    def * =
      (transactionId :: returnId :: claimingRelief :: reliefAmount :: reliefReason :: reliefSchemeNumber :: isLinked :: totalConsiderationLinked :: totalConsideration :: considerationBuild :: considerationCash :: considerationContingent :: considerationDebt :: considerationEmploy :: considerationOther :: considerationLand :: considerationServices :: considerationSharesQtd :: considerationSharesUnqtd :: considerationVat :: includesChattel :: includesGoodwill :: includesOther :: includesStock :: usedAsFactory :: usedAsHotel :: usedAsIndustrial :: usedAsOffice :: usedAsOther :: usedAsShop :: usedAsWarehouse :: contractDate :: isDependantOnFutureEvent :: newTransactionDescription :: transactionDescription :: effectiveDate :: isLandExchanged :: exchangedLandHouseNumber :: exchangedLandAddress1 :: exchangedLandAddress2 :: exchangedLandAddress3 :: exchangedLandAddress4 :: exchangedLandPostcode :: agreedToDeferPayment :: postTransRulingApplied :: isPursuantToPreviousOption :: restrictionsAffectInterest :: restrictionDetails :: postTransRulingFollowed :: isPartOfSaleOfBusiness :: totalConsiderationBusiness :: lMigrated :: createDate :: lastUpdateDate :: HNil)
        .mapTo[TransactionBackupRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(transactionId) :: Rep.Some(
      returnId
    ) :: claimingRelief :: reliefAmount :: reliefReason :: reliefSchemeNumber :: isLinked :: totalConsiderationLinked :: totalConsideration :: considerationBuild :: considerationCash :: considerationContingent :: considerationDebt :: considerationEmploy :: considerationOther :: considerationLand :: considerationServices :: considerationSharesQtd :: considerationSharesUnqtd :: considerationVat :: includesChattel :: includesGoodwill :: includesOther :: includesStock :: usedAsFactory :: usedAsHotel :: usedAsIndustrial :: usedAsOffice :: usedAsOther :: usedAsShop :: usedAsWarehouse :: contractDate :: isDependantOnFutureEvent :: newTransactionDescription :: transactionDescription :: effectiveDate :: isLandExchanged :: exchangedLandHouseNumber :: exchangedLandAddress1 :: exchangedLandAddress2 :: exchangedLandAddress3 :: exchangedLandAddress4 :: exchangedLandPostcode :: agreedToDeferPayment :: postTransRulingApplied :: isPursuantToPreviousOption :: restrictionsAffectInterest :: restrictionDetails :: postTransRulingFollowed :: isPartOfSaleOfBusiness :: totalConsiderationBusiness :: lMigrated :: Rep
      .Some(createDate) :: Rep.Some(lastUpdateDate) :: HNil).shaped.<>(
      r =>
        TransactionBackupRow(
          r.productElement(0).asInstanceOf[Option[scala.math.BigDecimal]].get,
          r.productElement(1).asInstanceOf[Option[scala.math.BigDecimal]].get,
          r.productElement(2).asInstanceOf[Option[String]],
          r.productElement(3).asInstanceOf[Option[String]],
          r.productElement(4).asInstanceOf[Option[String]],
          r.productElement(5).asInstanceOf[Option[String]],
          r.productElement(6).asInstanceOf[Option[String]],
          r.productElement(7).asInstanceOf[Option[String]],
          r.productElement(8).asInstanceOf[Option[String]],
          r.productElement(9).asInstanceOf[Option[String]],
          r.productElement(10).asInstanceOf[Option[String]],
          r.productElement(11).asInstanceOf[Option[String]],
          r.productElement(12).asInstanceOf[Option[String]],
          r.productElement(13).asInstanceOf[Option[String]],
          r.productElement(14).asInstanceOf[Option[String]],
          r.productElement(15).asInstanceOf[Option[String]],
          r.productElement(16).asInstanceOf[Option[String]],
          r.productElement(17).asInstanceOf[Option[String]],
          r.productElement(18).asInstanceOf[Option[String]],
          r.productElement(19).asInstanceOf[Option[String]],
          r.productElement(20).asInstanceOf[Option[String]],
          r.productElement(21).asInstanceOf[Option[String]],
          r.productElement(22).asInstanceOf[Option[String]],
          r.productElement(23).asInstanceOf[Option[String]],
          r.productElement(24).asInstanceOf[Option[String]],
          r.productElement(25).asInstanceOf[Option[String]],
          r.productElement(26).asInstanceOf[Option[String]],
          r.productElement(27).asInstanceOf[Option[String]],
          r.productElement(28).asInstanceOf[Option[String]],
          r.productElement(29).asInstanceOf[Option[String]],
          r.productElement(30).asInstanceOf[Option[String]],
          r.productElement(31).asInstanceOf[Option[String]],
          r.productElement(32).asInstanceOf[Option[String]],
          r.productElement(33).asInstanceOf[Option[String]],
          r.productElement(34).asInstanceOf[Option[String]],
          r.productElement(35).asInstanceOf[Option[String]],
          r.productElement(36).asInstanceOf[Option[String]],
          r.productElement(37).asInstanceOf[Option[String]],
          r.productElement(38).asInstanceOf[Option[String]],
          r.productElement(39).asInstanceOf[Option[String]],
          r.productElement(40).asInstanceOf[Option[String]],
          r.productElement(41).asInstanceOf[Option[String]],
          r.productElement(42).asInstanceOf[Option[String]],
          r.productElement(43).asInstanceOf[Option[String]],
          r.productElement(44).asInstanceOf[Option[String]],
          r.productElement(45).asInstanceOf[Option[String]],
          r.productElement(46).asInstanceOf[Option[String]],
          r.productElement(47).asInstanceOf[Option[String]],
          r.productElement(48).asInstanceOf[Option[String]],
          r.productElement(49).asInstanceOf[Option[String]],
          r.productElement(50).asInstanceOf[Option[String]],
          r.productElement(51).asInstanceOf[Option[scala.math.BigDecimal]],
          r.productElement(52).asInstanceOf[Option[java.sql.Timestamp]].get,
          r.productElement(53).asInstanceOf[Option[java.sql.Timestamp]].get
        ),
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column TRANSACTION_ID SqlType(NUMBER) */
    val transactionId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("TRANSACTION_ID")

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column CLAIMING_RELIEF SqlType(VARCHAR2), Length(500,true) */
    val claimingRelief: Rep[Option[String]] = column[Option[String]]("CLAIMING_RELIEF", O.Length(500, varying = true))

    /** Database column RELIEF_AMOUNT SqlType(VARCHAR2), Length(500,true) */
    val reliefAmount: Rep[Option[String]] = column[Option[String]]("RELIEF_AMOUNT", O.Length(500, varying = true))

    /** Database column RELIEF_REASON SqlType(VARCHAR2), Length(500,true) */
    val reliefReason: Rep[Option[String]] = column[Option[String]]("RELIEF_REASON", O.Length(500, varying = true))

    /** Database column RELIEF_SCHEME_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val reliefSchemeNumber: Rep[Option[String]] =
      column[Option[String]]("RELIEF_SCHEME_NUMBER", O.Length(500, varying = true))

    /** Database column IS_LINKED SqlType(VARCHAR2), Length(3,true) */
    val isLinked: Rep[Option[String]] = column[Option[String]]("IS_LINKED", O.Length(3, varying = true))

    /** Database column TOTAL_CONSIDERATION_LINKED SqlType(VARCHAR2), Length(500,true) */
    val totalConsiderationLinked: Rep[Option[String]] =
      column[Option[String]]("TOTAL_CONSIDERATION_LINKED", O.Length(500, varying = true))

    /** Database column TOTAL_CONSIDERATION SqlType(VARCHAR2), Length(500,true) */
    val totalConsideration: Rep[Option[String]] =
      column[Option[String]]("TOTAL_CONSIDERATION", O.Length(500, varying = true))

    /** Database column CONSIDERATION_BUILD SqlType(VARCHAR2), Length(3,true) */
    val considerationBuild: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_BUILD", O.Length(3, varying = true))

    /** Database column CONSIDERATION_CASH SqlType(VARCHAR2), Length(3,true) */
    val considerationCash: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_CASH", O.Length(3, varying = true))

    /** Database column CONSIDERATION_CONTINGENT SqlType(VARCHAR2), Length(3,true) */
    val considerationContingent: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_CONTINGENT", O.Length(3, varying = true))

    /** Database column CONSIDERATION_DEBT SqlType(VARCHAR2), Length(3,true) */
    val considerationDebt: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_DEBT", O.Length(3, varying = true))

    /** Database column CONSIDERATION_EMPLOY SqlType(VARCHAR2), Length(3,true) */
    val considerationEmploy: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_EMPLOY", O.Length(3, varying = true))

    /** Database column CONSIDERATION_OTHER SqlType(VARCHAR2), Length(3,true) */
    val considerationOther: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_OTHER", O.Length(3, varying = true))

    /** Database column CONSIDERATION_LAND SqlType(VARCHAR2), Length(3,true) */
    val considerationLand: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_LAND", O.Length(3, varying = true))

    /** Database column CONSIDERATION_SERVICES SqlType(VARCHAR2), Length(3,true) */
    val considerationServices: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_SERVICES", O.Length(3, varying = true))

    /** Database column CONSIDERATION_SHARES_QTD SqlType(VARCHAR2), Length(3,true) */
    val considerationSharesQtd: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_SHARES_QTD", O.Length(3, varying = true))

    /** Database column CONSIDERATION_SHARES_UNQTD SqlType(VARCHAR2), Length(3,true) */
    val considerationSharesUnqtd: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_SHARES_UNQTD", O.Length(3, varying = true))

    /** Database column CONSIDERATION_VAT SqlType(VARCHAR2), Length(500,true) */
    val considerationVat: Rep[Option[String]] =
      column[Option[String]]("CONSIDERATION_VAT", O.Length(500, varying = true))

    /** Database column INCLUDES_CHATTEL SqlType(VARCHAR2), Length(3,true) */
    val includesChattel: Rep[Option[String]] = column[Option[String]]("INCLUDES_CHATTEL", O.Length(3, varying = true))

    /** Database column INCLUDES_GOODWILL SqlType(VARCHAR2), Length(3,true) */
    val includesGoodwill: Rep[Option[String]] = column[Option[String]]("INCLUDES_GOODWILL", O.Length(3, varying = true))

    /** Database column INCLUDES_OTHER SqlType(VARCHAR2), Length(3,true) */
    val includesOther: Rep[Option[String]] = column[Option[String]]("INCLUDES_OTHER", O.Length(3, varying = true))

    /** Database column INCLUDES_STOCK SqlType(VARCHAR2), Length(3,true) */
    val includesStock: Rep[Option[String]] = column[Option[String]]("INCLUDES_STOCK", O.Length(3, varying = true))

    /** Database column USED_AS_FACTORY SqlType(VARCHAR2), Length(3,true) */
    val usedAsFactory: Rep[Option[String]] = column[Option[String]]("USED_AS_FACTORY", O.Length(3, varying = true))

    /** Database column USED_AS_HOTEL SqlType(VARCHAR2), Length(3,true) */
    val usedAsHotel: Rep[Option[String]] = column[Option[String]]("USED_AS_HOTEL", O.Length(3, varying = true))

    /** Database column USED_AS_INDUSTRIAL SqlType(VARCHAR2), Length(3,true) */
    val usedAsIndustrial: Rep[Option[String]] =
      column[Option[String]]("USED_AS_INDUSTRIAL", O.Length(3, varying = true))

    /** Database column USED_AS_OFFICE SqlType(VARCHAR2), Length(3,true) */
    val usedAsOffice: Rep[Option[String]] = column[Option[String]]("USED_AS_OFFICE", O.Length(3, varying = true))

    /** Database column USED_AS_OTHER SqlType(VARCHAR2), Length(3,true) */
    val usedAsOther: Rep[Option[String]] = column[Option[String]]("USED_AS_OTHER", O.Length(3, varying = true))

    /** Database column USED_AS_SHOP SqlType(VARCHAR2), Length(3,true) */
    val usedAsShop: Rep[Option[String]] = column[Option[String]]("USED_AS_SHOP", O.Length(3, varying = true))

    /** Database column USED_AS_WAREHOUSE SqlType(VARCHAR2), Length(3,true) */
    val usedAsWarehouse: Rep[Option[String]] = column[Option[String]]("USED_AS_WAREHOUSE", O.Length(3, varying = true))

    /** Database column CONTRACT_DATE SqlType(VARCHAR2), Length(500,true) */
    val contractDate: Rep[Option[String]] = column[Option[String]]("CONTRACT_DATE", O.Length(500, varying = true))

    /** Database column IS_DEPENDANT_ON_FUTURE_EVENT SqlType(VARCHAR2), Length(3,true) */
    val isDependantOnFutureEvent: Rep[Option[String]] =
      column[Option[String]]("IS_DEPENDANT_ON_FUTURE_EVENT", O.Length(3, varying = true))

    /** Database column NEW_TRANSACTION_DESCRIPTION SqlType(VARCHAR2), Length(500,true) */
    val newTransactionDescription: Rep[Option[String]] =
      column[Option[String]]("NEW_TRANSACTION_DESCRIPTION", O.Length(500, varying = true))

    /** Database column TRANSACTION_DESCRIPTION SqlType(VARCHAR2), Length(500,true) */
    val transactionDescription: Rep[Option[String]] =
      column[Option[String]]("TRANSACTION_DESCRIPTION", O.Length(500, varying = true))

    /** Database column EFFECTIVE_DATE SqlType(VARCHAR2), Length(500,true) */
    val effectiveDate: Rep[Option[String]] = column[Option[String]]("EFFECTIVE_DATE", O.Length(500, varying = true))

    /** Database column IS_LAND_EXCHANGED SqlType(VARCHAR2), Length(3,true) */
    val isLandExchanged: Rep[Option[String]] = column[Option[String]]("IS_LAND_EXCHANGED", O.Length(3, varying = true))

    /** Database column EXCHANGED_LAND_HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val exchangedLandHouseNumber: Rep[Option[String]] =
      column[Option[String]]("EXCHANGED_LAND_HOUSE_NUMBER", O.Length(500, varying = true))

    /** Database column EXCHANGED_LAND_ADDRESS_1 SqlType(VARCHAR2), Length(500,true) */
    val exchangedLandAddress1: Rep[Option[String]] =
      column[Option[String]]("EXCHANGED_LAND_ADDRESS_1", O.Length(500, varying = true))

    /** Database column EXCHANGED_LAND_ADDRESS_2 SqlType(VARCHAR2), Length(500,true) */
    val exchangedLandAddress2: Rep[Option[String]] =
      column[Option[String]]("EXCHANGED_LAND_ADDRESS_2", O.Length(500, varying = true))

    /** Database column EXCHANGED_LAND_ADDRESS_3 SqlType(VARCHAR2), Length(500,true) */
    val exchangedLandAddress3: Rep[Option[String]] =
      column[Option[String]]("EXCHANGED_LAND_ADDRESS_3", O.Length(500, varying = true))

    /** Database column EXCHANGED_LAND_ADDRESS_4 SqlType(VARCHAR2), Length(500,true) */
    val exchangedLandAddress4: Rep[Option[String]] =
      column[Option[String]]("EXCHANGED_LAND_ADDRESS_4", O.Length(500, varying = true))

    /** Database column EXCHANGED_LAND_POSTCODE SqlType(VARCHAR2), Length(500,true) */
    val exchangedLandPostcode: Rep[Option[String]] =
      column[Option[String]]("EXCHANGED_LAND_POSTCODE", O.Length(500, varying = true))

    /** Database column AGREED_TO_DEFER_PAYMENT SqlType(VARCHAR2), Length(3,true) */
    val agreedToDeferPayment: Rep[Option[String]] =
      column[Option[String]]("AGREED_TO_DEFER_PAYMENT", O.Length(3, varying = true))

    /** Database column POST_TRANS_RULING_APPLIED SqlType(VARCHAR2), Length(3,true) */
    val postTransRulingApplied: Rep[Option[String]] =
      column[Option[String]]("POST_TRANS_RULING_APPLIED", O.Length(3, varying = true))

    /** Database column IS_PURSUANT_TO_PREVIOUS_OPTION SqlType(VARCHAR2), Length(3,true) */
    val isPursuantToPreviousOption: Rep[Option[String]] =
      column[Option[String]]("IS_PURSUANT_TO_PREVIOUS_OPTION", O.Length(3, varying = true))

    /** Database column RESTRICTIONS_AFFECT_INTEREST SqlType(VARCHAR2), Length(3,true) */
    val restrictionsAffectInterest: Rep[Option[String]] =
      column[Option[String]]("RESTRICTIONS_AFFECT_INTEREST", O.Length(3, varying = true))

    /** Database column RESTRICTION_DETAILS SqlType(VARCHAR2), Length(500,true) */
    val restrictionDetails: Rep[Option[String]] =
      column[Option[String]]("RESTRICTION_DETAILS", O.Length(500, varying = true))

    /** Database column POST_TRANS_RULING_FOLLOWED SqlType(VARCHAR2), Length(500,true) */
    val postTransRulingFollowed: Rep[Option[String]] =
      column[Option[String]]("POST_TRANS_RULING_FOLLOWED", O.Length(500, varying = true))

    /** Database column IS_PART_OF_SALE_OF_BUSINESS SqlType(VARCHAR2), Length(3,true) */
    val isPartOfSaleOfBusiness: Rep[Option[String]] =
      column[Option[String]]("IS_PART_OF_SALE_OF_BUSINESS", O.Length(3, varying = true))

    /** Database column TOTAL_CONSIDERATION_BUSINESS SqlType(VARCHAR2), Length(500,true) */
    val totalConsiderationBusiness: Rep[Option[String]] =
      column[Option[String]]("TOTAL_CONSIDERATION_BUSINESS", O.Length(500, varying = true))

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")
  }

  /** Collection-like TableQuery object for table TransactionBackup */
  lazy val TransactionBackup = new TableQuery(tag => new TransactionBackup(tag))

  /** Entity class storing rows of table TreatmentGroup
    * @param storn
    *   Database column STORN SqlType(VARCHAR2), Length(10,true)
    * @param groupingReference
    *   Database column GROUPING_REFERENCE SqlType(VARCHAR2), Length(255,true)
    * @param messageReference
    *   Database column MESSAGE_REFERENCE SqlType(VARCHAR2), Length(255,true)
    * @param treatment
    *   Database column TREATMENT SqlType(NUMBER)
    * @param datetime
    *   Database column DATETIME SqlType(TIMESTAMP(6))
    */
  case class TreatmentGroupRow(
    storn: String,
    groupingReference: String,
    messageReference: String,
    treatment: scala.math.BigDecimal,
    datetime: Option[java.sql.Timestamp]
  )

  /** GetResult implicit for fetching TreatmentGroupRow objects using plain SQL queries */
  implicit def GetResultTreatmentGroupRow(implicit
    e0: GR[String],
    e1: GR[scala.math.BigDecimal],
    e2: GR[Option[java.sql.Timestamp]]
  ): GR[TreatmentGroupRow] = GR { prs =>
    import prs._
    (TreatmentGroupRow.apply _).tupled(
      (<<[String], <<[String], <<[String], <<[scala.math.BigDecimal], <<?[java.sql.Timestamp])
    )
  }

  /** Table description of table TREATMENT_GROUP. Objects of this class serve as prototypes for rows in queries. */
  class TreatmentGroup(_tableTag: Tag)
      extends profile.api.Table[TreatmentGroupRow](_tableTag, Some("SDLT_FILE_DATA"), "TREATMENT_GROUP") {
    def * = ((storn, groupingReference, messageReference, treatment, datetime)).mapTo[TreatmentGroupRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? =
      ((Rep.Some(storn), Rep.Some(groupingReference), Rep.Some(messageReference), Rep.Some(treatment), datetime)).shaped
        .<>(
          { r =>
            import r._; _1.map(_ => (TreatmentGroupRow.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5)))
          },
          (_: Any) => throw new Exception("Inserting into ? projection not supported.")
        )

    /** Database column STORN SqlType(VARCHAR2), Length(10,true) */
    val storn: Rep[String] = column[String]("STORN", O.Length(10, varying = true))

    /** Database column GROUPING_REFERENCE SqlType(VARCHAR2), Length(255,true) */
    val groupingReference: Rep[String] = column[String]("GROUPING_REFERENCE", O.Length(255, varying = true))

    /** Database column MESSAGE_REFERENCE SqlType(VARCHAR2), Length(255,true) */
    val messageReference: Rep[String] = column[String]("MESSAGE_REFERENCE", O.Length(255, varying = true))

    /** Database column TREATMENT SqlType(NUMBER) */
    val treatment: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("TREATMENT")

    /** Database column DATETIME SqlType(TIMESTAMP(6)) */
    val datetime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("DATETIME")

    /** Primary key of TreatmentGroup (database name TREATMENT_GROUP_PK) */
    val pk = primaryKey("TREATMENT_GROUP_PK", (storn, groupingReference, messageReference))
  }

  /** Collection-like TableQuery object for table TreatmentGroup */
  lazy val TreatmentGroup = new TableQuery(tag => new TreatmentGroup(tag))

  /** Entity class storing rows of table Vendor
    * @param vendorId
    *   Database column VENDOR_ID SqlType(NUMBER), PrimaryKey
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param title
    *   Database column TITLE SqlType(VARCHAR2), Length(500,true)
    * @param forename1
    *   Database column FORENAME1 SqlType(VARCHAR2), Length(500,true)
    * @param forename2
    *   Database column FORENAME2 SqlType(VARCHAR2), Length(500,true)
    * @param name
    *   Database column NAME SqlType(VARCHAR2), Length(500,true)
    * @param houseNumber
    *   Database column HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param address1
    *   Database column ADDRESS_1 SqlType(VARCHAR2), Length(500,true)
    * @param address2
    *   Database column ADDRESS_2 SqlType(VARCHAR2), Length(500,true)
    * @param address3
    *   Database column ADDRESS_3 SqlType(VARCHAR2), Length(500,true)
    * @param address4
    *   Database column ADDRESS_4 SqlType(VARCHAR2), Length(500,true)
    * @param postcode
    *   Database column POSTCODE SqlType(VARCHAR2), Length(500,true)
    * @param isRepresentedByAgent
    *   Database column IS_REPRESENTED_BY_AGENT SqlType(VARCHAR2), Length(3,true)
    * @param vendorResourceRef
    *   Database column VENDOR_RESOURCE_REF SqlType(NUMBER)
    * @param nextVendorId
    *   Database column NEXT_VENDOR_ID SqlType(NUMBER)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    */
  case class VendorRow(
    vendorId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    title: Option[String],
    forename1: Option[String],
    forename2: Option[String],
    name: Option[String],
    houseNumber: Option[String],
    address1: Option[String],
    address2: Option[String],
    address3: Option[String],
    address4: Option[String],
    postcode: Option[String],
    isRepresentedByAgent: Option[String],
    vendorResourceRef: Option[scala.math.BigDecimal],
    nextVendorId: Option[scala.math.BigDecimal],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp
  )

  /** GetResult implicit for fetching VendorRow objects using plain SQL queries */
  implicit def GetResultVendorRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[String]],
    e2: GR[Option[scala.math.BigDecimal]],
    e3: GR[java.sql.Timestamp]
  ): GR[VendorRow] = GR { prs =>
    import prs._
    (VendorRow.apply _).tupled(
      (
        <<[scala.math.BigDecimal],
        <<[scala.math.BigDecimal],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<[java.sql.Timestamp],
        <<[java.sql.Timestamp]
      )
    )
  }

  /** Table description of table VENDOR. Objects of this class serve as prototypes for rows in queries. */
  class Vendor(_tableTag: Tag) extends profile.api.Table[VendorRow](_tableTag, Some("SDLT_FILE_DATA"), "VENDOR") {
    def * = (
      (
        vendorId,
        returnId,
        title,
        forename1,
        forename2,
        name,
        houseNumber,
        address1,
        address2,
        address3,
        address4,
        postcode,
        isRepresentedByAgent,
        vendorResourceRef,
        nextVendorId,
        lMigrated,
        createDate,
        lastUpdateDate
      )
    ).mapTo[VendorRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(vendorId),
        Rep.Some(returnId),
        title,
        forename1,
        forename2,
        name,
        houseNumber,
        address1,
        address2,
        address3,
        address4,
        postcode,
        isRepresentedByAgent,
        vendorResourceRef,
        nextVendorId,
        lMigrated,
        Rep.Some(createDate),
        Rep.Some(lastUpdateDate)
      )
    ).shaped.<>(
      { r =>
        import r._;
        _1.map(_ =>
          (VendorRow.apply _)
            .tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17.get, _18.get))
        )
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column VENDOR_ID SqlType(NUMBER), PrimaryKey */
    val vendorId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("VENDOR_ID", O.PrimaryKey)

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column TITLE SqlType(VARCHAR2), Length(500,true) */
    val title: Rep[Option[String]] = column[Option[String]]("TITLE", O.Length(500, varying = true))

    /** Database column FORENAME1 SqlType(VARCHAR2), Length(500,true) */
    val forename1: Rep[Option[String]] = column[Option[String]]("FORENAME1", O.Length(500, varying = true))

    /** Database column FORENAME2 SqlType(VARCHAR2), Length(500,true) */
    val forename2: Rep[Option[String]] = column[Option[String]]("FORENAME2", O.Length(500, varying = true))

    /** Database column NAME SqlType(VARCHAR2), Length(500,true) */
    val name: Rep[Option[String]] = column[Option[String]]("NAME", O.Length(500, varying = true))

    /** Database column HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val houseNumber: Rep[Option[String]] = column[Option[String]]("HOUSE_NUMBER", O.Length(500, varying = true))

    /** Database column ADDRESS_1 SqlType(VARCHAR2), Length(500,true) */
    val address1: Rep[Option[String]] = column[Option[String]]("ADDRESS_1", O.Length(500, varying = true))

    /** Database column ADDRESS_2 SqlType(VARCHAR2), Length(500,true) */
    val address2: Rep[Option[String]] = column[Option[String]]("ADDRESS_2", O.Length(500, varying = true))

    /** Database column ADDRESS_3 SqlType(VARCHAR2), Length(500,true) */
    val address3: Rep[Option[String]] = column[Option[String]]("ADDRESS_3", O.Length(500, varying = true))

    /** Database column ADDRESS_4 SqlType(VARCHAR2), Length(500,true) */
    val address4: Rep[Option[String]] = column[Option[String]]("ADDRESS_4", O.Length(500, varying = true))

    /** Database column POSTCODE SqlType(VARCHAR2), Length(500,true) */
    val postcode: Rep[Option[String]] = column[Option[String]]("POSTCODE", O.Length(500, varying = true))

    /** Database column IS_REPRESENTED_BY_AGENT SqlType(VARCHAR2), Length(3,true) */
    val isRepresentedByAgent: Rep[Option[String]] =
      column[Option[String]]("IS_REPRESENTED_BY_AGENT", O.Length(3, varying = true))

    /** Database column VENDOR_RESOURCE_REF SqlType(NUMBER) */
    val vendorResourceRef: Rep[Option[scala.math.BigDecimal]] =
      column[Option[scala.math.BigDecimal]]("VENDOR_RESOURCE_REF")

    /** Database column NEXT_VENDOR_ID SqlType(NUMBER) */
    val nextVendorId: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("NEXT_VENDOR_ID")

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")

    /** Foreign key referencing Return (database name VENDOR_RETURN_FCK) */
    lazy val returnFk = foreignKey("VENDOR_RETURN_FCK", returnId, Return)(
      r => r.returnId,
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )

    /** Foreign key referencing Vendor (database name VENDOR_VENDOR_FK) */
    lazy val vendorFk = foreignKey("VENDOR_VENDOR_FK", nextVendorId, Vendor)(
      r => Rep.Some(r.vendorId),
      onUpdate = ForeignKeyAction.Cascade,
      onDelete = ForeignKeyAction.Restrict
    )
  }

  /** Collection-like TableQuery object for table Vendor */
  lazy val Vendor = new TableQuery(tag => new Vendor(tag))

  /** Entity class storing rows of table VendorBackup
    * @param vendorId
    *   Database column VENDOR_ID SqlType(NUMBER)
    * @param returnId
    *   Database column RETURN_ID SqlType(NUMBER)
    * @param title
    *   Database column TITLE SqlType(VARCHAR2), Length(500,true)
    * @param forename1
    *   Database column FORENAME1 SqlType(VARCHAR2), Length(500,true)
    * @param forename2
    *   Database column FORENAME2 SqlType(VARCHAR2), Length(500,true)
    * @param name
    *   Database column NAME SqlType(VARCHAR2), Length(500,true)
    * @param houseNumber
    *   Database column HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true)
    * @param address1
    *   Database column ADDRESS_1 SqlType(VARCHAR2), Length(500,true)
    * @param address2
    *   Database column ADDRESS_2 SqlType(VARCHAR2), Length(500,true)
    * @param address3
    *   Database column ADDRESS_3 SqlType(VARCHAR2), Length(500,true)
    * @param address4
    *   Database column ADDRESS_4 SqlType(VARCHAR2), Length(500,true)
    * @param postcode
    *   Database column POSTCODE SqlType(VARCHAR2), Length(500,true)
    * @param isRepresentedByAgent
    *   Database column IS_REPRESENTED_BY_AGENT SqlType(VARCHAR2), Length(3,true)
    * @param vendorResourceRef
    *   Database column VENDOR_RESOURCE_REF SqlType(NUMBER)
    * @param nextVendorId
    *   Database column NEXT_VENDOR_ID SqlType(NUMBER)
    * @param lMigrated
    *   Database column L_MIGRATED SqlType(NUMBER)
    * @param createDate
    *   Database column CREATE_DATE SqlType(DATE)
    * @param lastUpdateDate
    *   Database column LAST_UPDATE_DATE SqlType(DATE)
    */
  case class VendorBackupRow(
    vendorId: scala.math.BigDecimal,
    returnId: scala.math.BigDecimal,
    title: Option[String],
    forename1: Option[String],
    forename2: Option[String],
    name: Option[String],
    houseNumber: Option[String],
    address1: Option[String],
    address2: Option[String],
    address3: Option[String],
    address4: Option[String],
    postcode: Option[String],
    isRepresentedByAgent: Option[String],
    vendorResourceRef: Option[scala.math.BigDecimal],
    nextVendorId: Option[scala.math.BigDecimal],
    lMigrated: Option[scala.math.BigDecimal],
    createDate: java.sql.Timestamp,
    lastUpdateDate: java.sql.Timestamp
  )

  /** GetResult implicit for fetching VendorBackupRow objects using plain SQL queries */
  implicit def GetResultVendorBackupRow(implicit
    e0: GR[scala.math.BigDecimal],
    e1: GR[Option[String]],
    e2: GR[Option[scala.math.BigDecimal]],
    e3: GR[java.sql.Timestamp]
  ): GR[VendorBackupRow] = GR { prs =>
    import prs._
    (VendorBackupRow.apply _).tupled(
      (
        <<[scala.math.BigDecimal],
        <<[scala.math.BigDecimal],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[String],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<?[scala.math.BigDecimal],
        <<[java.sql.Timestamp],
        <<[java.sql.Timestamp]
      )
    )
  }

  /** Table description of table VENDOR_BACKUP. Objects of this class serve as prototypes for rows in queries. */
  class VendorBackup(_tableTag: Tag)
      extends profile.api.Table[VendorBackupRow](_tableTag, Some("SDLT_FILE_DATA"), "VENDOR_BACKUP") {
    def * = (
      (
        vendorId,
        returnId,
        title,
        forename1,
        forename2,
        name,
        houseNumber,
        address1,
        address2,
        address3,
        address4,
        postcode,
        isRepresentedByAgent,
        vendorResourceRef,
        nextVendorId,
        lMigrated,
        createDate,
        lastUpdateDate
      )
    ).mapTo[VendorBackupRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (
      (
        Rep.Some(vendorId),
        Rep.Some(returnId),
        title,
        forename1,
        forename2,
        name,
        houseNumber,
        address1,
        address2,
        address3,
        address4,
        postcode,
        isRepresentedByAgent,
        vendorResourceRef,
        nextVendorId,
        lMigrated,
        Rep.Some(createDate),
        Rep.Some(lastUpdateDate)
      )
    ).shaped.<>(
      { r =>
        import r._;
        _1.map(_ =>
          (VendorBackupRow.apply _)
            .tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17.get, _18.get))
        )
      },
      (_: Any) => throw new Exception("Inserting into ? projection not supported.")
    )

    /** Database column VENDOR_ID SqlType(NUMBER) */
    val vendorId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("VENDOR_ID")

    /** Database column RETURN_ID SqlType(NUMBER) */
    val returnId: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("RETURN_ID")

    /** Database column TITLE SqlType(VARCHAR2), Length(500,true) */
    val title: Rep[Option[String]] = column[Option[String]]("TITLE", O.Length(500, varying = true))

    /** Database column FORENAME1 SqlType(VARCHAR2), Length(500,true) */
    val forename1: Rep[Option[String]] = column[Option[String]]("FORENAME1", O.Length(500, varying = true))

    /** Database column FORENAME2 SqlType(VARCHAR2), Length(500,true) */
    val forename2: Rep[Option[String]] = column[Option[String]]("FORENAME2", O.Length(500, varying = true))

    /** Database column NAME SqlType(VARCHAR2), Length(500,true) */
    val name: Rep[Option[String]] = column[Option[String]]("NAME", O.Length(500, varying = true))

    /** Database column HOUSE_NUMBER SqlType(VARCHAR2), Length(500,true) */
    val houseNumber: Rep[Option[String]] = column[Option[String]]("HOUSE_NUMBER", O.Length(500, varying = true))

    /** Database column ADDRESS_1 SqlType(VARCHAR2), Length(500,true) */
    val address1: Rep[Option[String]] = column[Option[String]]("ADDRESS_1", O.Length(500, varying = true))

    /** Database column ADDRESS_2 SqlType(VARCHAR2), Length(500,true) */
    val address2: Rep[Option[String]] = column[Option[String]]("ADDRESS_2", O.Length(500, varying = true))

    /** Database column ADDRESS_3 SqlType(VARCHAR2), Length(500,true) */
    val address3: Rep[Option[String]] = column[Option[String]]("ADDRESS_3", O.Length(500, varying = true))

    /** Database column ADDRESS_4 SqlType(VARCHAR2), Length(500,true) */
    val address4: Rep[Option[String]] = column[Option[String]]("ADDRESS_4", O.Length(500, varying = true))

    /** Database column POSTCODE SqlType(VARCHAR2), Length(500,true) */
    val postcode: Rep[Option[String]] = column[Option[String]]("POSTCODE", O.Length(500, varying = true))

    /** Database column IS_REPRESENTED_BY_AGENT SqlType(VARCHAR2), Length(3,true) */
    val isRepresentedByAgent: Rep[Option[String]] =
      column[Option[String]]("IS_REPRESENTED_BY_AGENT", O.Length(3, varying = true))

    /** Database column VENDOR_RESOURCE_REF SqlType(NUMBER) */
    val vendorResourceRef: Rep[Option[scala.math.BigDecimal]] =
      column[Option[scala.math.BigDecimal]]("VENDOR_RESOURCE_REF")

    /** Database column NEXT_VENDOR_ID SqlType(NUMBER) */
    val nextVendorId: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("NEXT_VENDOR_ID")

    /** Database column L_MIGRATED SqlType(NUMBER) */
    val lMigrated: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("L_MIGRATED")

    /** Database column CREATE_DATE SqlType(DATE) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_DATE")

    /** Database column LAST_UPDATE_DATE SqlType(DATE) */
    val lastUpdateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("LAST_UPDATE_DATE")
  }

  /** Collection-like TableQuery object for table VendorBackup */
  lazy val VendorBackup = new TableQuery(tag => new VendorBackup(tag))
}
