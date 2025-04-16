"use client"

import { useState } from "react"
import {
  AlertCircle,
  ArrowDownIcon,
  ArrowUpIcon,
  BrainCircuit,
  CheckCircle2,
  IndianRupeeIcon,
  LightbulbIcon,
  TrendingDownIcon,
  TrendingUpIcon,
  XCircle,
} from "lucide-react"

import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs"
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select"
import { Badge } from "@/components/ui/badge"
import { Progress } from "@/components/ui/progress"
import { Separator } from "@/components/ui/separator"

export default function InsightsPage() {
  const [timeframe, setTimeframe] = useState("month")
  const [isLoading, setIsLoading] = useState(false)

  // Sample data - in a real application, you would fetch this from your API
  const [insightsData, setInsightsData] = useState({
    totalSpent: 45000,
    monthlyTrend: 12,
    anomalies: [
      { category: "Dining", amount: 8500, percentageIncrease: 65, month: "June" },
      { category: "Entertainment", amount: 6200, percentageIncrease: 48, month: "June" },
    ],
    savingOpportunities: [
      {
        category: "Shopping",
        amount: 12000,
        potentialSaving: 3500,
        recommendations: [
          "Create a shopping list before purchasing and avoid impulse buys",
          "Wait 24 hours before making non-essential purchases",
          "Look for sales and discounts for planned purchases",
        ],
      },
      {
        category: "Subscriptions",
        amount: 4500,
        potentialSaving: 1800,
        recommendations: [
          "Review your subscriptions and cancel those you rarely use",
          "Consider sharing subscription costs with family or friends",
          "Look for annual payment options that offer discounts",
        ],
      },
      {
        category: "Dining",
        amount: 8500,
        potentialSaving: 2800,
        recommendations: [
          "Cook at home more often instead of eating out",
          "Use meal planning to reduce food waste",
          "Look for restaurant deals and happy hours when dining out",
        ],
      },
    ],
    categoryInsights: [
      {
        category: "Groceries",
        spent: 5500,
        budget: 6000,
        status: "good",
        trend: "stable",
        insight: "Your grocery spending is consistent and within budget.",
        recommendation: "Continue your current shopping habits. Consider buying in bulk for additional savings.",
      },
      {
        category: "Dining",
        spent: 8500,
        budget: 5000,
        status: "warning",
        trend: "increasing",
        insight: "Your dining expenses have increased by 65% this month.",
        recommendation: "Consider cooking at home more often. Limit restaurant visits to special occasions.",
      },
      {
        category: "Entertainment",
        spent: 6200,
        budget: 4000,
        status: "warning",
        trend: "increasing",
        insight: "Entertainment spending is 48% higher than your monthly average.",
        recommendation: "Look for free or low-cost entertainment options. Check for discounts and deals.",
      },
      {
        category: "Shopping",
        spent: 12000,
        budget: 8000,
        status: "critical",
        trend: "high",
        insight: "Shopping is your highest expense category, exceeding budget by 50%.",
        recommendation: "Create a shopping list and stick to it. Avoid impulse purchases and unnecessary items.",
      },
      {
        category: "Utilities",
        spent: 5800,
        budget: 6000,
        status: "good",
        trend: "stable",
        insight: "Your utility expenses are well-managed and within budget.",
        recommendation: "Continue your current usage patterns. Consider energy-saving options for additional savings.",
      },
    ],
    unusualTransactions: [
      {
        description: "Online Electronics Store",
        amount: 4500,
        date: "June 15, 2023",
        category: "Shopping",
        reason: "Significantly higher than your usual electronics spending",
      },
      {
        description: "Restaurant Charges",
        amount: 2800,
        date: "June 22, 2023",
        category: "Dining",
        reason: "Multiple restaurant charges in a single day",
      },
    ],
    smartTips: [
      "Based on your spending patterns, you could save ₹5,300 monthly by following our recommendations",
      "Your highest expense day is typically Friday - consider planning weekend activities in advance",
      "You tend to make impulse purchases in the Shopping category - try implementing a 24-hour waiting period",
      "Your subscription services account for 10% of your monthly expenses - review for unused services",
      "Setting up automatic transfers to savings on payday could help you save before spending",
    ],
  })

  // In a real application, you would fetch the insights data from your API
  // useEffect(() => {
  //   const userId = localStorage.getItem("userId")
  //   setIsLoading(true)
  //   axios
  //     .get(`/api/insights?userId=${userId}`)
  //     .then((response) => {
  //       setInsightsData(response.data)
  //       setIsLoading(false)
  //     })
  //     .catch((error) => {
  //       console.error("Error fetching insights data:", error)
  //       setIsLoading(false)
  //     })
  // }, [])

  return (
    <div className="flex-1 space-y-4 p-4 md:p-8">
      <div className="flex items-center justify-between">
        <div className="space-y-1">
          <h2 className="text-3xl font-bold tracking-tight flex items-center">
            <BrainCircuit className="mr-2 h-6 w-6" />
            AI Insights
          </h2>
          <p className="text-muted-foreground">
            Smart analysis of your spending habits and personalized recommendations
          </p>
        </div>
        <div className="flex items-center gap-2">
          <Select value={timeframe} onValueChange={setTimeframe}>
            <SelectTrigger className="w-[180px]">
              <SelectValue placeholder="Select timeframe" />
            </SelectTrigger>
            <SelectContent>
              <SelectItem value="week">This Week</SelectItem>
              <SelectItem value="month">This Month</SelectItem>
              <SelectItem value="quarter">This Quarter</SelectItem>
              <SelectItem value="year">This Year</SelectItem>
            </SelectContent>
          </Select>
        </div>
      </div>

      {/* Key Insights Summary */}
      <div className="grid gap-4 md:grid-cols-2 lg:grid-cols-4">
        <Card>
          <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
            <CardTitle className="text-sm font-medium">Monthly Trend</CardTitle>
            <TrendingUpIcon className="h-4 w-4 text-red-500" />
          </CardHeader>
          <CardContent>
            <div className="text-2xl font-bold flex items-center">
              {insightsData.monthlyTrend > 0 ? (
                <ArrowUpIcon className="mr-1 h-4 w-4 text-red-500" />
              ) : (
                <ArrowDownIcon className="mr-1 h-4 w-4 text-emerald-500" />
              )}
              {Math.abs(insightsData.monthlyTrend)}%
            </div>
            <p className="text-xs text-muted-foreground">
              {insightsData.monthlyTrend > 0
                ? "Increase in spending compared to last month"
                : "Decrease in spending compared to last month"}
            </p>
          </CardContent>
        </Card>

        <Card>
          <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
            <CardTitle className="text-sm font-medium">Spending Anomalies</CardTitle>
            <AlertCircle className="h-4 w-4 text-amber-500" />
          </CardHeader>
          <CardContent>
            <div className="text-2xl font-bold">{insightsData.anomalies.length}</div>
            <p className="text-xs text-muted-foreground">Unusual spending patterns detected</p>
          </CardContent>
        </Card>

        <Card>
          <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
            <CardTitle className="text-sm font-medium">Saving Opportunities</CardTitle>
            <IndianRupeeIcon className="h-4 w-4 text-emerald-500" />
          </CardHeader>
          <CardContent>
            <div className="text-2xl font-bold flex">
              <IndianRupeeIcon className="mt-1 h-5 w-5" />
              {insightsData.savingOpportunities
                .reduce((total, item) => total + item.potentialSaving, 0)
                .toLocaleString()}
            </div>
            <p className="text-xs text-muted-foreground">Potential monthly savings identified</p>
          </CardContent>
        </Card>

        <Card>
          <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
            <CardTitle className="text-sm font-medium">Budget Status</CardTitle>
            <XCircle className="h-4 w-4 text-red-500" />
          </CardHeader>
          <CardContent>
            <div className="text-2xl font-bold">3 of 5</div>
            <p className="text-xs text-muted-foreground">Categories exceeding budget</p>
          </CardContent>
        </Card>
      </div>

      {/* Main Insights Content */}
      <Tabs defaultValue="overview" className="space-y-4">
        <TabsList>
          <TabsTrigger value="overview">Overview</TabsTrigger>
          <TabsTrigger value="categories">Categories</TabsTrigger>
          <TabsTrigger value="recommendations">Recommendations</TabsTrigger>
          <TabsTrigger value="unusual">Unusual Activity</TabsTrigger>
        </TabsList>

        {/* Overview Tab */}
        <TabsContent value="overview" className="space-y-4">
          <Card>
            <CardHeader>
              <CardTitle className="flex items-center">
                <LightbulbIcon className="mr-2 h-5 w-5" />
                AI Summary
              </CardTitle>
              <CardDescription>Key insights about your spending habits</CardDescription>
            </CardHeader>
            <CardContent className="space-y-4">
              <div className="space-y-4">
                <div className="flex items-start">
                  <div className="mr-2 rounded-full bg-black p-1">
                    <TrendingUpIcon className="h-3 w-3 text-white" />
                  </div>
                  <p className="text-sm">
                    Your spending has increased by <strong>12%</strong> compared to last month, primarily in Dining and
                    Entertainment categories.
                  </p>
                </div>

                <div className="flex items-start">
                  <div className="mr-2 rounded-full bg-black p-1">
                    <AlertCircle className="h-3 w-3 text-white" />
                  </div>
                  <p className="text-sm">
                    <strong>Shopping</strong> represents your largest expense category at <strong>27%</strong> of total
                    spending and is <strong>50% over budget</strong>.
                  </p>
                </div>

                <div className="flex items-start">
                  <div className="mr-2 rounded-full bg-black p-1">
                    <TrendingDownIcon className="h-3 w-3 text-white" />
                  </div>
                  <p className="text-sm">
                    You could save up to <strong>₹8,100</strong> monthly by optimizing your Shopping, Dining, and
                    Subscription expenses.
                  </p>
                </div>

                <div className="flex items-start">
                  <div className="mr-2 rounded-full bg-black p-1">
                    <AlertCircle className="h-3 w-3 text-white" />
                  </div>
                  <p className="text-sm">
                    Unusual spending detected in <strong>Dining</strong> (65% increase) and{" "}
                    <strong>Entertainment</strong> (48% increase).
                  </p>
                </div>
              </div>

              <Separator className="my-4" />

              <div>
                <h3 className="font-medium mb-3">Smart Tips</h3>
                <ul className="space-y-2">
                  {insightsData.smartTips.map((tip, index) => (
                    <li key={index} className="flex items-start">
                      <LightbulbIcon className="h-4 w-4 mr-2 text-amber-500 shrink-0 mt-0.5" />
                      <span className="text-sm">{tip}</span>
                    </li>
                  ))}
                </ul>
              </div>
            </CardContent>
          </Card>
        </TabsContent>

        {/* Categories Tab */}
        <TabsContent value="categories" className="space-y-4">
          <Card>
            <CardHeader>
              <CardTitle>Category Analysis</CardTitle>
              <CardDescription>Detailed insights for each spending category</CardDescription>
            </CardHeader>
            <CardContent>
              <div className="space-y-6">
                {insightsData.categoryInsights.map((category, index) => (
                  <div key={index} className="space-y-3">
                    <div className="flex items-center justify-between">
                      <div className="flex items-center">
                        {category.status === "good" ? (
                          <CheckCircle2 className="mr-2 h-5 w-5 text-emerald-500" />
                        ) : category.status === "warning" ? (
                          <AlertCircle className="mr-2 h-5 w-5 text-amber-500" />
                        ) : (
                          <XCircle className="mr-2 h-5 w-5 text-red-500" />
                        )}
                        <h3 className="font-medium">{category.category}</h3>
                      </div>
                      <Badge
                        variant={
                          category.status === "good"
                            ? "outline"
                            : category.status === "warning"
                              ? "secondary"
                              : "destructive"
                        }
                      >
                        {category.trend === "stable" && "Stable"}
                        {category.trend === "increasing" && "Increasing"}
                        {category.trend === "high" && "High"}
                      </Badge>
                    </div>

                    <div className="grid grid-cols-2 gap-4 text-sm">
                      <div>
                        <p className="text-muted-foreground">Spent</p>
                        <p className="font-medium flex items-center">
                          <IndianRupeeIcon className="h-3 w-3 mr-1" />
                          {category.spent.toLocaleString()}
                        </p>
                      </div>
                      <div>
                        <p className="text-muted-foreground">Budget</p>
                        <p className="font-medium flex items-center">
                          <IndianRupeeIcon className="h-3 w-3 mr-1" />
                          {category.budget.toLocaleString()}
                        </p>
                      </div>
                    </div>

                    <div className="space-y-1">
                      <div className="flex items-center justify-between text-sm">
                        <span className="text-muted-foreground">Budget usage</span>
                        <span
                          className={
                            category.status === "good"
                              ? "text-emerald-500"
                              : category.status === "warning"
                                ? "text-amber-500"
                                : "text-red-500"
                          }
                        >
                          {Math.round((category.spent / category.budget) * 100)}%
                        </span>
                      </div>
                      <Progress
                        value={(category.spent / category.budget) * 100}
                        className={`h-2 ${
                          category.status === "good"
                            ? "bg-emerald-100"
                            : category.status === "warning"
                              ? "bg-amber-100"
                              : "bg-red-100"
                        }`}
                      />
                    </div>

                    <div className="space-y-1">
                      <p className="text-sm font-medium">Insight</p>
                      <p className="text-sm text-muted-foreground">{category.insight}</p>
                    </div>

                    <div className="space-y-1">
                      <p className="text-sm font-medium">Recommendation</p>
                      <p className="text-sm text-muted-foreground">{category.recommendation}</p>
                    </div>

                    {index < insightsData.categoryInsights.length - 1 && <Separator className="my-2" />}
                  </div>
                ))}
              </div>
            </CardContent>
          </Card>
        </TabsContent>

        {/* Recommendations Tab */}
        <TabsContent value="recommendations" className="space-y-4">
          <Card>
            <CardHeader>
              <CardTitle>Personalized Recommendations</CardTitle>
              <CardDescription>AI-powered suggestions to improve your financial health</CardDescription>
            </CardHeader>
            <CardContent>
              <div className="space-y-6">
                <div>
                  <h3 className="font-medium mb-3">Saving Opportunities</h3>
                  <div className="space-y-6">
                    {insightsData.savingOpportunities.map((opportunity, index) => (
                      <div key={index} className="space-y-3">
                        <div className="flex items-center justify-between">
                          <span className="font-medium">{opportunity.category}</span>
                          <Badge variant="outline" className="bg-emerald-50">
                            Save ₹{opportunity.potentialSaving.toLocaleString()}
                          </Badge>
                        </div>
                        <div className="flex items-center justify-between text-sm">
                          <span className="text-muted-foreground">Current spending:</span>
                          <span className="flex items-center">
                            <IndianRupeeIcon className="mr-1 h-3 w-3" />
                            {opportunity.amount.toLocaleString()}
                          </span>
                        </div>

                        <div className="space-y-2">
                          <p className="text-sm font-medium">Recommendations:</p>
                          <ul className="space-y-1">
                            {opportunity.recommendations.map((rec, recIndex) => (
                              <li key={recIndex} className="flex items-start text-sm text-muted-foreground">
                                <div className="mr-2 rounded-full bg-black p-1 mt-0.5 shrink-0">
                                  <CheckCircle2 className="h-2 w-2 text-white" />
                                </div>
                                {rec}
                              </li>
                            ))}
                          </ul>
                        </div>

                        {index < insightsData.savingOpportunities.length - 1 && <Separator className="my-2" />}
                      </div>
                    ))}
                  </div>
                </div>

                <Separator className="my-4" />

                <div>
                  <h3 className="font-medium mb-3">Action Plan</h3>
                  <div className="space-y-3">
                    <div className="rounded-md border p-4 bg-gray-50">
                      <h4 className="font-medium mb-2">Immediate Actions</h4>
                      <ul className="space-y-2">
                        <li className="flex items-start text-sm">
                          <div className="mr-2 rounded-full bg-black p-1 mt-0.5 shrink-0">
                            <CheckCircle2 className="h-2 w-2 text-white" />
                          </div>
                          Review and cancel unused subscription services to save ₹1,800 monthly
                        </li>
                        <li className="flex items-start text-sm">
                          <div className="mr-2 rounded-full bg-black p-1 mt-0.5 shrink-0">
                            <CheckCircle2 className="h-2 w-2 text-white" />
                          </div>
                          Implement a 24-hour waiting period for non-essential purchases
                        </li>
                        <li className="flex items-start text-sm">
                          <div className="mr-2 rounded-full bg-black p-1 mt-0.5 shrink-0">
                            <CheckCircle2 className="h-2 w-2 text-white" />
                          </div>
                          Plan meals for the week to reduce dining out expenses
                        </li>
                      </ul>
                    </div>

                    <div className="rounded-md border p-4 bg-gray-50">
                      <h4 className="font-medium mb-2">This Month's Goals</h4>
                      <ul className="space-y-2">
                        <li className="flex items-start text-sm">
                          <div className="mr-2 rounded-full bg-black p-1 mt-0.5 shrink-0">
                            <CheckCircle2 className="h-2 w-2 text-white" />
                          </div>
                          Reduce dining expenses by 30% (Target: ₹5,950)
                        </li>
                        <li className="flex items-start text-sm">
                          <div className="mr-2 rounded-full bg-black p-1 mt-0.5 shrink-0">
                            <CheckCircle2 className="h-2 w-2 text-white" />
                          </div>
                          Keep shopping expenses within budget (Target: ₹8,000)
                        </li>
                        <li className="flex items-start text-sm">
                          <div className="mr-2 rounded-full bg-black p-1 mt-0.5 shrink-0">
                            <CheckCircle2 className="h-2 w-2 text-white" />
                          </div>
                          Save at least ₹5,000 from your total potential savings
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </CardContent>
          </Card>
        </TabsContent>

        {/* Unusual Activity Tab */}
        <TabsContent value="unusual" className="space-y-4">
          <Card>
            <CardHeader>
              <CardTitle>Unusual Spending Activity</CardTitle>
              <CardDescription>Transactions that deviate from your normal spending patterns</CardDescription>
            </CardHeader>
            <CardContent className="space-y-6">
              <div className="space-y-4">
                {insightsData.unusualTransactions.map((transaction, index) => (
                  <div key={index} className="rounded-md border p-4">
                    <div className="flex items-start justify-between">
                      <div>
                        <h3 className="font-medium">{transaction.description}</h3>
                        <p className="text-sm text-muted-foreground">{transaction.date}</p>
                      </div>
                      <Badge variant="outline" className="bg-amber-50">
                        {transaction.category}
                      </Badge>
                    </div>

                    <div className="mt-3 flex items-center">
                      <span className="text-muted-foreground text-sm mr-2">Amount:</span>
                      <span className="font-medium flex items-center">
                        <IndianRupeeIcon className="mr-1 h-3 w-3" />
                        {transaction.amount.toLocaleString()}
                      </span>
                    </div>

                    <div className="mt-3 flex items-start">
                      <AlertCircle className="h-4 w-4 text-amber-500 mr-2 mt-0.5 shrink-0" />
                      <p className="text-sm">{transaction.reason}</p>
                    </div>
                  </div>
                ))}
              </div>

              <div className="rounded-md border p-4 bg-gray-50">
                <h3 className="font-medium mb-2">Anomaly Detection</h3>
                <p className="text-sm text-muted-foreground mb-3">
                  Our AI has detected unusual spending patterns in the following categories:
                </p>

                <div className="space-y-4">
                  {insightsData.anomalies.map((anomaly, index) => (
                    <div key={index} className="space-y-2">
                      <div className="flex items-center justify-between">
                        <div className="flex items-center">
                          <AlertCircle className="mr-2 h-4 w-4 text-amber-500" />
                          <h4 className="font-medium">{anomaly.category}</h4>
                        </div>
                        <Badge variant="outline" className="bg-amber-50">
                          {anomaly.percentageIncrease}% Increase
                        </Badge>
                      </div>

                      <div className="flex items-center justify-between text-sm">
                        <span className="text-muted-foreground">Current spending:</span>
                        <span className="font-medium flex items-center">
                          <IndianRupeeIcon className="mr-1 h-3 w-3" />
                          {anomaly.amount.toLocaleString()}
                        </span>
                      </div>

                      <p className="text-sm text-muted-foreground">
                        Your {anomaly.category.toLowerCase()} spending in {anomaly.month} is significantly higher than
                        your usual pattern.
                        {anomaly.category === "Dining"
                          ? " Consider cooking at home more often or limiting restaurant visits."
                          : " Look for more affordable alternatives or reduce frequency."}
                      </p>
                    </div>
                  ))}
                </div>
              </div>
            </CardContent>
          </Card>
        </TabsContent>
      </Tabs>
    </div>
  )
}
